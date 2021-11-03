<template>
  <div id="mSub">
    <h2 id="kakaoBody"
        class="screen_out">We are Friends!</h2>
    <div class="visual_charinfo lang_on"
         :lang="$route.params.lang">
      <p class="screen_out">저마다의 개성과 인간적인 매력을 지닌 여덟 친구들 카카오프렌즈</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'char-sub',
  mounted() {
    const preloadImages = [
      'https://t1.kakaocdn.net/friends/prod/info/bg_charInfo_en_W.png',
      'https://t1.kakaocdn.net/friends/prod/info/bg_charInfo_ja_W.png',
      'https://t1.kakaocdn.net/friends/prod/info/bg_charInfo_sc_W.png',
      'https://t1.kakaocdn.net/friends/prod/info/bg_charInfo_tc_W.png',
    ]

    preloadImages.forEach(img => {
      const preloadLink = document.createElement('link')
      preloadLink.href = img
      preloadLink.rel = 'preload'
      preloadLink.as = 'image'
      document.head.appendChild(preloadLink)
    })
  },
}
</script>