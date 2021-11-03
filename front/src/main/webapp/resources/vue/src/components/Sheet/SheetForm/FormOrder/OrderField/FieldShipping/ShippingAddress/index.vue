<template>
  <div>
    <address-zone></address-zone>
    <address-state></address-state>
    <address-city></address-city>
    <address-street></address-street>
  </div>
</template>

<script>
import AddressZone from './AddressZone'
import AddressState from './AddressState'
import AddressCity from './AddressCity'
import AddressStreet from './AddressStreet'

export default {
  name: 'shipping-address',
  components: {
    AddressZone,
    AddressState,
    AddressCity,
    AddressStreet,
  },
}
</script>
