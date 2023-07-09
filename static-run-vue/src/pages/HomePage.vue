<script setup>
import { getSysConfig } from "@/request/system.request";
import Login from "@/components/Login.vue";

getSysConfig().then(res => {
  console.log(res.data)
})

</script>

<template>
<login />
</template>

<style scoped>

</style>