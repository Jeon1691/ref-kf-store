<template>
  <div class="order_attention">
    <strong class="tit_attention">{{ $t('usage_note.title') }}</strong>
    <ul class="list_attention">
      <li v-for="(li, index) in $t('usage_note.list')"
          :key="index">{{ li }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'footer-attention',
}
</script>
