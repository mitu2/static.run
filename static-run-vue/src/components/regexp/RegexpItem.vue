<script setup>

const { child } = defineProps({
  child: String
})

</script>

<template>
  <template v-if="child.type === 'text'">
    <span
        class="regexp-input"
        contenteditable="true"
    />
  </template>
</template>

<style scoped>
.regexp-input {
  display: inline-block;
  min-width: 45px;
  font-size: 18px;
  line-height: 30px;
  border-bottom: 1px solid;
  word-break: break-all;
}

.regexp-input:focus-visible {
  outline: none;
}
</style>