<script setup>
import { computed, ref, watchEffect } from "vue";
import { useOsTheme } from "naive-ui";
import { useRouter } from "vue-router";
import { Moon as MoonIcon, Sunny as SunnyIcon } from "@vicons/ionicons5";
import useModuleStore from "@/store/useModuleStore";

const osThemeRef = useOsTheme()
const { state } = useModuleStore('system')
const theme = computed(() => state.theme || osThemeRef.value)
const inverted = computed(() => theme.value === 'dark')

const router = useRouter()

const menuOptions = [ ...router.options.routes ]
const menuKey = ref('')


watchEffect(() => {
  menuKey.value = router.currentRoute.value.name;
})

function handleUpdateValue(key, item) {
  router.push({ name: key })
}

function handleUpdateThemeValue(value) {
  state.theme = value;
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
            :value="menuKey"
            key-field="name"
            :options="menuOptions"
            mode="horizontal"
            :inverted="inverted"
            @update:value="handleUpdateValue"
        />
        <n-switch v-model:value="state.theme"
                  size="medium"
                  checked-value="dark"
                  :default-value="theme"
                  unchecked-value="light"
                  :on-update:value="handleUpdateThemeValue"
        >
          <template #icon>
            <n-icon>
              <sunny-icon v-show="theme === 'light'"/>
              <moon-icon v-show="theme === 'dark'"/>
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