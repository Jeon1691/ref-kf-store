<template>
  <ul class="tab_friends">
    <li v-for="filter in filters"
        :key="filter.key"
        :class="{ on: filter.key === area.key }">
      <a class="link_tab"
         @click="onClick(filter)">{{ filter.name }}</a>
    </li>
  </ul>
</template>

<script>
import mixin from './mixin'

export default {
  name: 'stores-tab',
  mixins: [mixin],
}
</script>

<style scoped>
.link_tab {
  cursor: pointer;
}
</style>
