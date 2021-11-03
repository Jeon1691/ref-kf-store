<template>
  <div class="wrap_charinfo lang_on"
       :lang="$route.params.lang">
    <char-section v-for="char in $t('chars.items')"
                  :key="char.id"
                  :id="char.id"
                  :name="char.name"
                  :desc="char.desc"
                  :longdesc="char.longdesc"
                  :group="char.group"></char-section>
  </div>
</template>

<script>
import CharSection from './CharSection'

export default {
  name: 'article-char',
  components: {
    CharSection,
  },
}
</script>