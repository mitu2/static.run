<script setup>
import { darkTheme, dateZhCN, lightTheme, useOsTheme, zhCN } from 'naive-ui';
import { computed } from "vue";

import { marked } from 'marked';
import hljs from 'highlight.js/lib/core';
import markdown from 'highlight.js/lib/languages/markdown';
import 'highlight.js/styles/github.css'

import GeneralHeader from '@/components/GeneralHeader.vue';
import useModuleStore from "@/store/useModuleStore";
import GeneralFooter from "@/components/GeneralFooter.vue";

const osThemeRef = useOsTheme()
const { state } = useModuleStore('system')


let theme = computed(() => (state.theme || osThemeRef.value) === 'dark' ? darkTheme : lightTheme)

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
  <n-config-provider :theme="theme" :locale="zhCN" :date-locale="dateZhCN" :hljs="hljs" style="height: 100%">
    <n-global-style/>
    <n-message-provider>
      <n-layout bordered style="height: 100%">
        <general-header/>
        <n-layout-content>
          <router-view/>
        </n-layout-content>
        <general-footer/>
      </n-layout>
      <n-back-top :right="100"/>
    </n-message-provider>
  </n-config-provider>
</template>
