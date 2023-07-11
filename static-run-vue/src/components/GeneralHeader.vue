<script setup>
import { computed, h } from "vue";
import { useMessage, useOsTheme } from "naive-ui";
import { RouterLink } from "vue-router";
import { Moon as MoonIcon, Sunny as SunnyIcon } from "@vicons/ionicons5";
import useModuleStore from "@/store/useModuleStore";

const osThemeRef = useOsTheme()
const { state } = useModuleStore('system')
let inverted = computed(() => (!state.theme || state.theme === 'dark') && osThemeRef.value === 'dark')

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
  },
  {
    label: () => h(
        RouterLink,
        {
          to: {
            name: "LeaveMessage",
            params: {}
          }
        },
        { default: () => "留言板" }
    ),
    key: "go-leave-message",
  },
  {
    label: "小工具",
    key: "tool",
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
  <n-layout-header bordered :inverted='inverted'>
    <n-grid x-gap="12">
      <n-gi span="2">
        <div class="logo">
          <n-gradient-text
              gradient="linear-gradient(90deg, red 0%, green 50%, blue 100%)"
          >
            Easy Tools
          </n-gradient-text>
        </div>
      </n-gi>
      <n-gi span="10">
        <n-menu
            :options="menuOptions"
            mode="horizontal"
            :inverted="inverted"
            @update:value="handleUpdateValue"
        />
        <n-switch v-model:value="state.theme" size="medium" checked-value="dark" unchecked-value="light">
          <template #icon>
            <n-icon>
              <sunny-icon v-show="state.theme === 'light'"/>
              <moon-icon v-show="state.theme === 'dark'"/>
            </n-icon>
          </template>
        </n-switch>
      </n-gi>
    </n-grid>


  </n-layout-header>

</template>

<style scoped>
.logo {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}
</style>