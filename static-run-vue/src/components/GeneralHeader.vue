<script setup>
import { h } from "vue";
import { NIcon, useMessage } from "naive-ui";
import { RouterLink } from "vue-router";
import { HomeOutline as HomeIcon } from "@vicons/ionicons5";
import ToolIcon from "../icon/ToolIcon.vue";

function renderIcon(icon) {
  return () => h(NIcon, null, { default: () => h(icon) });
}

const menuOptions = [
  {
    label: () => h(
        RouterLink,
        {
          to: {
            name: "Home",
            params: {}
          }
        },
        { default: () => "首页" }
    ),
    key: "go-back-home",
    icon: renderIcon(HomeIcon)
  },
  {
    label: "小工具",
    key: "tool",
    icon: renderIcon(ToolIcon),
    children: [
      {
        type: "group",
        label: "浏览器",
        key: "browser",
        children: [
          {
            label: () => h(
                RouterLink,
                {
                  to: {
                    name: "ShortUrl",
                    params: {}
                  }
                },
                { default: () => "短网址" }
            ),
            key: "go-short-url",
          },
        ]
      },
      {
        type: "group",
        label: "编程相关",
        key: "code",
        children: [
          {
            label: () => h(
                RouterLink,
                {
                  to: {
                    name: "Regexp",
                    params: {}
                  }
                },
                { default: () => "正则编辑器" }
            ),
            key: "go-regexp",
          },
        ]
      },
    ]
  },
];

const message = useMessage();

function handleUpdateValue(key, item) {
  message.info("[onUpdate:value]: " + JSON.stringify(key));
  message.info("[onUpdate:value]: " + JSON.stringify(item));
}

</script>

<template>
  <div id="general-header">
    <n-menu
        id="general-header-menu"
        :options="menuOptions"
        mode="horizontal"
        @update:value="handleUpdateValue"
    />
  </div>
</template>

<style scoped>
#general-header {
  margin-bottom: 5px;
}
#general-header-menu {
  padding-top: 10px;
  padding-bottom: 10px;
}
</style>