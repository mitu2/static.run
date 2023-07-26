<script setup>
import { getLoginUserInfo } from "@/request/user.request";
import GiteeIcon from "@/icon/GiteeIcon.vue";
import { LogoGithub as GithubIcon } from "@vicons/ionicons5";
import { useMessage } from "naive-ui";

const message = useMessage()

function doLogin(type) {

  const iWidth = 1266;
  const iHeight = 789;
  const iTop = (window.screen.height - 30 - iHeight) / 2;       //获得窗口的垂直位置;
  const iLeft = (window.screen.width - 10 - iWidth) / 2;        //获得窗口的水平位置;

  const loginPage = window.open(
      `${ import.meta.env.VITE_API_URL }/oauth2/authorization/${ type }`,
      undefined,
      `toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, copyhistory=no, width=${ iWidth }, height=${ iHeight }, top=${ iTop }, left=${ iLeft }`
  )


  if (loginPage) {
    const key = setInterval(() => {
      console.log(closed)
      if (!loginPage.closed) {
        return
      }
      getLoginUserInfo()
          .then(resp => {
            const { data } = resp
            message.success(`【${ data.name }】 登录成功`)
          })
          .catch(reason => {
            message.error('登录失败: ' + reason?.response?.data?.errMessage || '未知原因')
          })
      // 关掉定时器
      clearInterval(key)
    }, 100)
  }

}
</script>

<template>
  <n-button :on-click="() => doLogin('gitee')" quaternary circle>
    <template #icon>
      <n-icon>
        <gitee-icon/>
      </n-icon>
    </template>
  </n-button>
  <n-button :on-click="() => doLogin('github')" quaternary circle>
    <template #icon>
      <n-icon>
        <github-icon/>
      </n-icon>
    </template>
  </n-button>
</template>

<style scoped>

</style>