<template>
  <div class="group_order_foot">
    <div class="order_attention">
      <strong class="tit_attention">{{ $t('usage_note.title') }}</strong>
      <ul class="list_attention">
        <li v-for="(li, index) in $t('usage_note.list')"
            :key="index">{{ li }}</li>
      </ul>
    </div>

    <div class="order_end">
      <a :href="`/${$LANG}/index`"
         class="btn_order">
        <span class="txt_g">{{ $t('usage_note.go_home') }}</span>
      </a>
    </div>
  </div>
</template>

<script>
export default {
  name: 'complete-footer',
}
</script>
