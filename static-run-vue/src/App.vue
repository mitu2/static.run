<script setup>
import { darkTheme, dateZhCN, lightTheme, useOsTheme, zhCN } from 'naive-ui';
import { computed } from "vue";

import { marked } from 'marked';
import hljs from 'highlight.js/lib/core';
import markdown from 'highlight.js/lib/languages/markdown';
import 'highlight.js/styles/github.css'

import GeneralHeader from '@/components/GeneralHeader.vue';
import useModuleStore from "@/store/useModuleStore";

const osThemeRef = useOsTheme()
const { state } = useModuleStore('system')

if(!state.theme) {
  state.theme = osThemeRef.value;
}

let theme = computed(() => (!state.theme || state.theme === 'dark') && osThemeRef.value === 'dark' ? darkTheme : lightTheme)

hljs.registerLanguage('markdown', markdown);

const renderer = new marked.Renderer();

marked.setOptions({
  renderer: renderer,
  gfm: true,
  pedantic: false,
  sanitize: false,
  tables: true,
  breaks: false,
  smartLists: true,
  smartypants: false,
  highlight: function (code) {
    return hljs.highlightAuto(code).value;
  }
});

</script>

<template>
  <n-config-provider :theme="theme" :locale="zhCN" :date-locale="dateZhCN" :hljs="hljs">
    <n-global-style/>
    <n-message-provider>
      <n-layout>
          <general-header/>
          <router-view/>
      </n-layout>
      <n-back-top :right="100"/>
    </n-message-provider>
  </n-config-provider>
</template>
