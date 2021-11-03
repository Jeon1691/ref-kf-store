<template>
  <div class="FlagshipMap">
    <div class="FlagshipMap-canvas"
         :id="`flagship-map-${index}`"
         style="position: absolute;"></div>
    <a :href="`https://www.google.com/maps/place/${info.url}`"
       class="FlagshipMap-link"
       target="_blank">
      {{ $t('stores.message.view_map') }}
    </a>
  </div>
</template>

<script>
export default {
  name: 'flagship-map',
  props: {
    info: {
      type: Object,
      required: true,
    },
    index: {
      type: Number,
      required: true,
    },
  },
  mounted() {
    setTimeout(() => {
      const { google } = window
      const center = { lat: this.info.lat, lng: this.info.lng }

      const map = new google.maps.Map(document.getElementById(`flagship-map-${this.index}`), {
        zoom: 16,
        center,
        disableDefaultUI: true,
      })

      new google.maps.Marker({
        position: center,
        map,
      })
    }, (this.index + 1) * 250)
  },
}
</script>
