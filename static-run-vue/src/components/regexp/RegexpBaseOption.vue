<script setup>

import useModuleStore from "@/store/useModuleStore";

const { index } = defineProps({
  index: Number
})

const { state } = useModuleStore('regexp')
const it = state.items[index]

</script>

<template>
  <n-row>
    <n-col :span="8">
      <n-checkbox :checked="it.option.isReverseSelection"
                  :on-update:checked="value => { if(value) { it.option.isMatchStart = it.option.isMatchEnd = false } it.option.isReverseSelection = value }">
        反转匹配
      </n-checkbox>
    </n-col>
    <n-col :span="8">
      <n-checkbox v-model:checked="it.option.isMatchStart" :disabled="it.option.isReverseSelection">
        匹配开头
        <n-text code>^</n-text>
      </n-checkbox>
    </n-col>
    <n-col :span="8">
      <n-checkbox v-model:checked="it.option.isMatchEnd" :disabled="it.option.isReverseSelection">
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
</template>

<style scoped>

</style>