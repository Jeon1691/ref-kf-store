<template>
  <app-overlay>
    <component :is="component"></component>
  </app-overlay>
</template>

<script>
import { mapState } from 'vuex'
import AppOverlay from '../Overlay'

export default {
  name: 'app-modal',
  components: {
    AppOverlay,
  },
  computed: {
    ...mapState({
      component: state => state.modal.component,
      name: state => state.modal.name,
    }),
  },
}
</script>
