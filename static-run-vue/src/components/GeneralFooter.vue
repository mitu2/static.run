<script setup>
import useModuleStore from "@/store/useModuleStore";
import { computed } from "vue";
import { useOsTheme } from "naive-ui";
import policeBadgeImage from "@/assets/police-badge.png";

const osThemeRef = useOsTheme()
const { state, dispatch } = useModuleStore('system')
const theme = computed(() => state.theme || osThemeRef.value)
const inverted = computed(() => theme.value === 'dark')

dispatch('initSysConfig')

</script>

<template>
  <n-layout-footer :inverted="inverted" bordered position="absolute" style="padding: 4px 0 4px 0;">
    <n-space style="text-align: center;" justify="center">
      <n-text type="tertiary">
        Unused (服务创建于
        <n-time :time="state.sysConfig.installDate" :to="Date.now()" type="relative"/>
        )©2023
      </n-text>
      <n-text>
        |
      </n-text>
      <n-button type="tertiary" text tag="a" href="https://beian.miit.gov.cn" target="_blank">
        冀ICP备2021022987号-1
      </n-button>
      <n-text>
        |
      </n-text>
      <n-button type="tertiary" text tag="a" target="_blank"
                href="https://www.beian.gov.cn/portal/registerSystemInfo?recordcode=13100202000682">
        <n-image :src="policeBadgeImage" class="footer-pb-desc-logo" alt="police-badge"/>
        冀公网安备 13100202000682号
      </n-button>
    </n-space>
  </n-layout-footer>
</template>

<style scoped>

.footer-pb-desc-logo {
  width: 14px;
  height: 14px;
}
</style>