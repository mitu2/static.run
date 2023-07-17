<script setup>
import useModuleStore from "@/store/useModuleStore";
import { computed } from "vue";
import { useOsTheme } from "naive-ui";
import policeBadgeImage from "@/assets/police-badge.png";

const osThemeRef = useOsTheme()
const { state } = useModuleStore('system')
const { dispatch } = useModuleStore('system')
const theme = computed(() => state.theme || osThemeRef.value)
const inverted = computed(() => theme.value === 'dark')

dispatch('initSysConfig')

</script>

<template>
  <n-layout-footer :inverted="inverted" bordered>
    <div class="footer">
      <n-a href="https://beian.miit.gov.cn" target="_blank">冀ICP备2021022987号-1</n-a>
      <n-text class="footer-pb-desc">
        <n-image :src="policeBadgeImage" class="footer-pb-desc-logo" alt="police-badge"/>
        <n-a target="_blank" href="https://www.beian.gov.cn/portal/registerSystemInfo?recordcode=13100202000682">
          冀公网安备 13100202000682号
        </n-a>
      </n-text>
    </div>
  </n-layout-footer>
</template>

<style scoped>
.footer {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  flex-direction: column;
  align-content: center;
  flex-wrap: nowrap;
}

.footer-pb-desc {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}

.footer-pb-desc-logo {
  width: 15px;
  height: 15px;
}
</style>