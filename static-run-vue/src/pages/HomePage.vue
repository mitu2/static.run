<script setup>
import { getSysConfig } from "@/request/system.request";
import GiteeIcon from "@/icon/GiteeIcon.vue";
import { getLoginUserInfo } from "@/request/user.request";

function doLogin(type) {
  const loginPage = window.open(
      `${import.meta.env.VITE_API_URL}/oauth2/authorization/${type}`,
      undefined,
      `toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, copyhistory=no, width= 400, height=750, bottom=0`
  )
  if(loginPage) {
    const key = setInterval(() => {
      if(!loginPage.closed) {
        return
      }
      getLoginUserInfo()
          .then(resp => {
            console.log(resp)
          })
          .catch(reason => {
            console.log(reason)
          })
      // 关掉定时器
      clearInterval(key)
    }, 100)
  }

}

getSysConfig().then(res => {
  console.log(res.data)
})

</script>

<template>
  <n-button :on-click="() => doLogin('gitee')">
    <template #icon>
      <n-icon size="32">
        <gitee-icon />
      </n-icon>
    </template>
  </n-button>
</template>

<style scoped>

</style>