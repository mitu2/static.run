<script setup>
import { getSysConfig } from "@/request/system.request";



getSysConfig().then(res => {
  console.log(res.data)
})
</script>

<template>
  <div class="page-content">

  </div>
</template>

<style scoped>

</style>