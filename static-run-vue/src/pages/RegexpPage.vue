<script setup>
import { ref } from "vue";
import { useMessage } from "naive-ui";

import useModuleStore from "@/store/useModuleStore";
import { Add as AddIcon } from "@vicons/ionicons5";
import RegexpItem from "@/components/regexp/RegexpItem.vue";
import RegexpBaseOption from "@/components/regexp/RegexpBaseOption.vue";
import RegexpElementOption from "@/components/regexp/RegexpElementOption.vue";

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
    recordName.value = ''
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

function testRegexp(config) {
  if (config.text) {
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
          <n-card title="操作框" size="small">
            <n-text class="regexp-side" code>
              {{
                '/' +
                getChar((!it.option.isReverseSelection && it.option.isMatchStart) && '^') +
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
                getChar((!it.option.isReverseSelection && it.option.isMatchEnd) && '$') + '/' +
                getChar(it.option.isUnixLines && 'g') +
                getChar(it.option.isCaseInsensitive && 'i') +
                getChar(it.option.isMultiline && 'm') +
                getChar(it.option.isDotall && 's') +
                getChar(it.option.isUnicodeCase && 'u') +
                getChar(it.option.isCanonEq && 'y')
              }}
            </n-text>
          </n-card>
          <n-card title="文本区" size="small">
            <n-input
                v-model:value="it.text"
                type="textarea"
            />
          </n-card>
          <n-card title="匹配结果" size="small">
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
          </n-card>
        </div>
        <n-tabs type="segment">
          <n-tab-pane name="baseConfig" tab="基本配置">
            <regexp-base-option :index="ind"/>
          </n-tab-pane>
          <n-tab-pane name="elementConfig" tab="元素配置">
            <regexp-element-option :index="ind"/>
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
