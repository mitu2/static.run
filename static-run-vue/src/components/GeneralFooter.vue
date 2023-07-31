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
  <n-layout-footer :inverted="inverted" bordered position="absolute" style="padding: 4px 0 4px 0;">
      <n-breadcrumb separator="|" style="text-align: center;">
        <n-breadcrumb-item :clickable="false">
          <n-text>
            Static.run © 2021-2023 沉默
          </n-text>
        </n-breadcrumb-item>
        <n-breadcrumb-item :clickable="false">
          <n-button text tag="a" href="https://beian.miit.gov.cn" target="_blank">
            冀ICP备2021022987号-1
          </n-button>
        </n-breadcrumb-item>
        <n-breadcrumb-item :clickable="false">
          <n-button text tag="a" target="_blank"
                    href="https://www.beian.gov.cn/portal/registerSystemInfo?recordcode=13100202000682">
            <n-image :src="policeBadgeImage" class="footer-pb-desc-logo" alt="police-badge"/>
            冀公网安备 13100202000682号
          </n-button>
        </n-breadcrumb-item>
      </n-breadcrumb>
  </n-layout-footer>
</template>

<style scoped>

.footer {
  align-items: center;
}


.footer-pb-desc-logo {
  width: 14px;
  height: 14px;
}
</style>