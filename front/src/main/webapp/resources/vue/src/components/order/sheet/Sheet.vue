<template>
  <div id="mArticle"
       class="IS_VUE">
    <sheet-form></sheet-form>
    <app-modal v-if="modal.isVisible"></app-modal>
    <app-dialog v-if="dialog.isVisible"></app-dialog>
  </div>
</template>

<script>
  import { mapState } from 'vuex'
  import '@/filters/order'
  import '@/directives/order'
  import AppModal from '@/components/common/Modal'
  import AppDialog from '@/components/common/Dialog'
  import SheetForm from './form/SheetForm'

  export default {
    name: 'Sheet',
    components: {
      SheetForm,
      AppModal,
      AppDialog
    },
    computed: {
      ...mapState(['modal', 'dialog', 'isFetching'])
    }
  }
</script>

<style>
  #mArticle a {
    cursor: pointer;
  }
</style>
