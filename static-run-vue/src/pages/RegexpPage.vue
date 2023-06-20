<script setup>
import { ref } from "vue";
import { useMessage } from "naive-ui";

import useModuleStore from "@/store/useModuleStore";
import { Add as AddIcon } from "@vicons/ionicons5";
import RegexpItem from "@/components/RegexpItem.vue";

const { state, commit } = useModuleStore('regexp')
const message = useMessage()

if (state.items.length === 0) {
  commit('addRegexpRecord', 'regexp_1')
}

function getChar(char) {
  if (char) {
    return char;
  }
  return ''
}

let recordName = ref('')

function addRegexpRecordByInput() {
  if (recordName.value) {
    commit('addRegexpRecord', recordName.value)
    return
  }
  message.error("请输入一个名称")
}

function addRegexpChild(child) {
  child.push({
    type: 'text',
    option: {},
    content: ''
  })
}

let text = ref('')

function testRegexp(config) {
  if (text.value.length === 0) {
    return [ [ { text: '无匹配数据', isMatch: false } ] ]
  }
  return [
    [ { text: '测试匹配', isMatch: false }, { text: '匹配成功Chen', isMatch: true } ],
    [ { text: '测试匹配2', isMatch: false } ],
  ]
}

</script>

<template>
  <n-list bordered hoverable>
    <template #header>
      在线正则编辑器
    </template>
    <n-list-item v-for="(it, ind) in state.items" :key="ind">
      <n-thing>
        <template #header>
          {{ it.name }}
        </template>
        <div class="regexp-item">
          <div class="regexp-item-line">
            <n-text class="regexp-side" code>
              {{
                '/' +
                getChar((!it.option.isReverseSelection && it.option.match.start) && '^') +
                getChar(it.option.isReverseSelection && '^((?!')
              }}
            </n-text>
            <regexp-item
                v-for="(chi, chiInd) in it.child"
                :child="chi"
                :key="chiInd"
            />
            <n-button quaternary round :on-click="() => addRegexpChild(it.child)" size="tiny">
              <template #icon>
                <n-icon>
                  <add-icon/>
                </n-icon>
              </template>
            </n-button>
            <n-text class="regexp-side" code>
              {{
                getChar(it.option.isReverseSelection && ').)*') +
                getChar((!it.option.isReverseSelection && it.option.match.end) && '$') + '/' +
                getChar(it.option.isUnixLines && 'g') +
                getChar(it.option.isCaseInsensitive && 'i') +
                getChar(it.option.isMultiline && 'm') +
                getChar(it.option.isDotall && 's') +
                getChar(it.option.isUnicodeCase && 'u') +
                getChar(it.option.isCanonEq && 'y')
              }}
            </n-text>
          </div>
          <n-space vertical>
            <n-input
                v-model:value="text"
                type="textarea"
                placeholder="测试文本输入地址"
            />
          </n-space>
          <n-space vertical>
            <n-ol align-text>
              <n-li v-for="(regIt, id) in testRegexp(it)" :key="id">
                <n-text v-for="(chiRegIt, chiId) in regIt"
                        :key="chiId"
                        :type="chiRegIt.isMatch ? 'error' : 'default'"
                        :strong="chiRegIt.isMatch">
                  {{ chiRegIt.text }}
                </n-text>
              </n-li>
            </n-ol>
          </n-space>
        </div>
        <n-tabs type="segment">
          <n-tab-pane name="baseConfig" tab="基本配置">
            <n-row>
              <n-col :span="8">
                <n-checkbox v-model:checked="it.option.isReverseSelection"
                            :on-change="value => { if(value) { it.option.match.start = it.option.match.end = false } return value; }">
                  反转匹配
                </n-checkbox>
              </n-col>
              <n-col :span="8">
                <n-checkbox v-model:checked="it.option.match.start" :disabled="it.option.isReverseSelection">
                  匹配开头
                  <n-text code>^</n-text>
                </n-checkbox>
              </n-col>
              <n-col :span="8">
                <n-checkbox v-model:checked="it.option.match.end" :disabled="it.option.isReverseSelection">
                  匹配结尾
                  <n-text code>$</n-text>
                </n-checkbox>
              </n-col>
            </n-row>
            <n-row>
              <n-col :span="12">
                <n-checkbox v-model:checked="it.option.isUnixLines">
                  全局搜索
                </n-checkbox>
              </n-col>
              <n-col :span="12">
                <n-checkbox v-model:checked="it.option.isCaseInsensitive">
                  不分大小写
                </n-checkbox>
              </n-col>
            </n-row>
            <n-row>
              <n-col :span="12">
                <n-checkbox v-model:checked="it.option.isMultiline">
                  多行匹配
                </n-checkbox>
              </n-col>
              <n-col :span="12">
                <n-checkbox v-model:checked="it.option.isDotall">
                  允许
                  <n-text code>.</n-text>
                  匹配换行符
                </n-checkbox>
              </n-col>
            </n-row>
            <n-row>
              <n-col :span="12">
                <n-checkbox v-model:checked="it.option.isUnicodeCase">
                  使用
                  <n-text code>unicode</n-text>
                  码的模式进行匹配
                </n-checkbox>
              </n-col>
              <n-col :span="12">
                <n-checkbox v-model:checked="it.option.isCanonEq">
                  执行
                  <n-text code>“粘性 (sticky)”</n-text>
                  搜索，匹配从目标字符串的当前位置开始
                </n-checkbox>
              </n-col>
            </n-row>
          </n-tab-pane>
          <n-tab-pane name="currConfig" tab="当前配置">
            1
          </n-tab-pane>
        </n-tabs>
      </n-thing>
    </n-list-item>
    <n-list-item>
      <n-thing title="操作">
        <n-input-group>
          <n-input :style="{ width: '40%' }" v-model:value="recordName" type="text" placeholder="正则表达式名称"/>
          <n-button type="primary" :on-click="addRegexpRecordByInput" ghost>新增</n-button>
        </n-input-group>
      </n-thing>
    </n-list-item>
  </n-list>
</template>

<style scoped>

.regexp-item {
  font-size: 20px;
}

</style>
