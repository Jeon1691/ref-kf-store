<template>
  <transition name="modal">
    <div ref="modalMask"
         class="modal-mask">
      <div ref="modalContainer"
           class="modal-container friends_layer"
           :class="{ [modal.name]: true, 'alert_layer': dialog.isVisible }">
        <slot></slot>
      </div>
    </div>
  </transition>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import ua from '@/common/ua'

export default {
  name: 'app-overlay',
  computed: {
    ...mapState(['modal', 'dialog']),
  },
  methods: {
    ...mapMutations(['HIDE_MODAL', 'HIDE_DIALOG']),
    onKeydown(e) {
      if (e.keyCode === 27) {
        this.HIDE_MODAL()
        this.HIDE_DIALOG()
      }
    },
  },
  mounted() {
    this.$refs.modalMask.style.height = `${document.body.clientHeight}px`
    this.$refs.modalContainer.style.top =
      this.modal.name === 'post_layer' && ua.device.type === 'mobile'
        ? '50px'
        : `${(window.innerHeight - this.$refs.modalContainer.clientHeight) / 2 +
            (document.body.scrollTop || document.documentElement.scrollTop)}px`

    if (ua.os.name === 'Android') {
      document.body.classList.add('is-android')
    }

    document.body.addEventListener('keydown', this.onKeydown)
  },
  destroyed() {
    document.body.classList.remove('is-android')
  },
}
</script>

<style>
.is-android .modal-container.post_layer {
  position: static;
  transform: none;
  background-color: transparent;
}

.is-android .post_layer .layer {
  top: 100px;
  right: 10px;
  bottom: 10px;
  left: 10px;
  width: auto;
  height: 466px;
}

.is-android .post_layer_close {
  float: right;
}
</style>

<style scoped>
.modal-mask {
  position: absolute;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.8);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.is-transform .modal-container {
  transition: transform 0.3s ease;
}

.is-transform .modal-enter .modal-container,
.is-transform .modal-leave-active .modal-container {
  transform: scale(1.1) translateY(-50%);
}

.friends_layer {
  display: block;
}

.post_layer {
  position: absolute;
  margin-top: 0;
}
</style>
