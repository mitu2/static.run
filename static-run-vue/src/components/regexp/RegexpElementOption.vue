<script setup>
import draggable from "vuedraggable";

import useModuleStore from "@/store/useModuleStore";
import { ref } from "vue";

const { index } = defineProps({
  index: Number
})

const { state } = useModuleStore('regexp')
const it = state.items[index]

const draggableBtn = ref([
  { id: 1, name: "test" }
])

function cloneDraggableBtn({ id }) {
   return {
    id,
    name: `cat ${id}`
  };
}
// TODO https://github.com/SortableJS/vue.draggable.next/blob/master/example/components/two-lists.vue

</script>

<template>
  <draggable
      class="dragArea list-group"
      :list="draggableBtn"
      :group="{ name: 'people', pull: 'clone', put: false }"
      :clone="cloneDraggableBtn"
      item-key="id"
  >
    <template #item="{ element }">
      <div class="list-group-item">
        {{ element.name }}
      </div>
    </template>
  </draggable>
</template>

<style scoped>

</style>