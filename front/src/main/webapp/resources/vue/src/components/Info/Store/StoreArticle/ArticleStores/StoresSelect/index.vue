<template>
  <div class="area_sort">
    <strong class="tit_sort">{{ $t('stores.select.title') }}</strong>
    <div :class="{
      opt_sort: true,
      sort_open: isMenuVisible
    }">
      <strong class="screen_out">{{ $t('stores.select.select_area') }}</strong>

      <a class="link_selected"
         tabindex="-1"
         @click="isMenuVisible = true">
        <span class="txt_sort"></span>
        <span class="screen_out">{{ $t('stores.select.selected') }}</span>
        <span class="ico_friends ico_arr"></span>
      </a>

      <div class="box_sort">
        <em class="screen_out">{{ $t('stores.select.select_option') }}</em>
        <ul class="list_sort">
          <li v-for="filter in filters"
              :key="filter.key"
              :class="{ on: filter.key === area.key }">
            <a class="link_sort"
               @click="handleClick(filter)">{{ filter.name }}</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import mixin from '../StoresTab/mixin'

export default {
  name: 'stores-select',
  mixins: [mixin],
  data() {
    return {
      isMenuVisible: false,
    }
  },
  methods: {
    handleClick(filter) {
      this.onClick(filter)
      this.isMenuVisible = false
    },
  },
  watch: {
    '$route.params.lang'() {
      const area = this.filters.filter(f => f.key === this.area.key)[0]
      const txt = document.querySelector('.txt_sort')

      txt.innerHTML = area.name
    },
  },
}
</script>
