<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<script>--%>
    <%--/* 임시 스크립트--%>
     <%--* .visual_charinfo, .wrap_charinfo, .item_tab, .link_banner 영역들을--%>
     <%--* 탭에서 클릭한 lang 속성에 따라 'lang_on' class를 추가하여 display:block 시켜줍니다.--%>
     <%--* */--%>
    <%--$(document).ready(function(){--%>
        <%--$(".link_tab").click(function(){--%>
            <%--var curLang = $(this).attr("lang"),--%>
                <%--onCls = "lang_on";--%>

            <%--$(".visual_charinfo, .wrap_charinfo, .item_tab, .link_banner").removeClass(onCls);--%>
            <%--$(".visual_charinfo:lang("+ curLang + "), .wrap_charinfo:lang("+ curLang + "), .link_banner:lang("+ curLang + ")").addClass(onCls);--%>
            <%--$(this).parent().addClass(onCls);--%>

            <%--return false;--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>

<div id="mArticle">
    <div class="wrap_tab">
        <ul class="tab_lang">
            <li class="item_tab item_kr"><a href="#none" class="link_tab" lang="ko">한국어</a></li>
            <li class="item_tab item_en"><a href="#none" class="link_tab" lang="en">English</a></li>
            <li class="item_tab item_ja"><a href="#none" class="link_tab" lang="ja">日本語</a></li>
            <li class="item_tab item_hans"><a href="#none" class="link_tab" lang="zh-Hans">中文(简体)</a></li>
            <li class="item_tab item_hant"><a href="#none" class="link_tab" lang="zh-Hant">中文(繁體)</a></li>
        </ul>
    </div>
    <!-- // tab -->

    <!-- ko -->
    <div class="wrap_charinfo lang_on" lang="ko">
        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_ryan"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_ryan">RYAN</h3>
                    <em class="desc_character">갈기가 없는 것이 콤플렉스인 수사자</em>
                    <p class="txt_character">
                        큰 덩치와 무뚝뚝한 표정으로 오해를 많이 사지만,<br class="rw_show">
                        사실 누구보다도 여리고 섬세한 소녀감성을 지닌 반전 매력의 소유자!<br class="rw_show">
                        원래 아프리카 둥둥섬 왕위 계승자였으나, 자유로운 삶을 동경해 탈출!<br class="rw_show">
                        카카오프렌즈의 든든한 조언자 역할을 맡고 있습니다.<br class="rw_show">
                        꼬리가 길면 잡히기 때문에, 꼬리가 짧습니다.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/23"><span class="ico_newfriends_v1 ico_arrow"></span>제품보기</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_apeach"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_apeach">APEACH</h3>
                    <em class="desc_character">복숭아 나무에서 탈출한 악동 복숭아</em>
                    <p class="txt_character">
                        유전자 변이로 자웅동주가 된 것을 알고<br class="rw_show">
                        복숭아 나무에서 탈출한 악동 복숭아 어피치!<br class="rw_show">
                        섹시한 뒷태로 사람들을 매혹시키며,<br class="rw_show">
                        성격이 매우 급하고 과격합니다.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/6"><span class="ico_newfriends_v1 ico_arrow"></span>제품보기</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_muzicon"></span>
                </div>
                <div class="area_cont">
                    <strong class="tit_character img_charInfo tit_muzicon">MUZI &amp; CON</strong>
                    <em class="desc_character">토끼 옷을 입은 단무지인 무지와 정체불명 콘</em>
                    <p class="txt_character">
                        호기심 많은 장난꾸러기 무지의 정체는 사실 토끼 옷을 입은 단무지!<br class="rw_show">
                        토끼 옷을 벗으면 부끄러움을 많이 탑니다.<br class="rw_show">
                        단무지를 키워 무지를 만든 정체불명의 악어 콘!<br class="rw_show">
                        이제는 복숭아를 키우고 싶어 어피치를 찾아 다닙니다.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/5"><span class="ico_newfriends_v1 ico_arrow"></span>제품보기</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_frodoneo"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_frodoneo">frodo&amp;neo</h3>
                    <em class="desc_character">부잣집 도시개 프로도와 패셔니스타 네오</em>
                    <p class="txt_character">
                        프로도와 네오는 카카오프렌즈 공식 커플로 알콩달콩 깨볶는 중!<br class="rw_show">
                        부잣집 도시개 프로도는 사실 잡종. 태생에 대한 콤플렉스가 많습니다.<br class="rw_show">
                        자기 자신을 가장 사랑하는 새침한 고양이 네오. 쇼핑을 좋아하는<br class="rw_show">
                        이 구역의 대표 패셔니스타입니다. 하지만 도도한 자신감의 근원이<br class="rw_show">
                        단발머리 ‘가발’에서 나온다는 건 비밀!
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/7"><span class="ico_newfriends_v1 ico_arrow"></span>제품보기</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_tube"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_tube">TUBE</h3>
                    <em class="desc_character">겁 많고 마음 약한 오리 튜브</em>
                    <p class="txt_character">
                        겁 많고 마음 약한 오리 튜브는 극도의 공포를 느끼면 미친 오리로<br class="rw_show">
                        변신합니다. 작은 발이 콤플렉스이기 때문에 큰 오리발을 착용합니다.<br class="rw_show">
                        미운 오리 새끼가 먼 친척입니다.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/9"><span class="ico_newfriends_v1 ico_arrow"></span>제품보기</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_jayg"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_jayg">JAY-G</h3>
                    <em class="desc_character">힙합을 사랑하는 자유로운 영혼</em>
                    <p class="txt_character">
                        땅속 나라 고향에 대한 향수병이 있는 비밀요원 제이지!<br>
                        사명의식이 투철하여 냉철해보이고 싶으나, 실은 어리버리합니다.<br class="rw_show">
                        겉모습과 달리 알고보면 외로움을 많이 타는 여린 감수성의 소유자.<br class="rw_show">
                        힙합 가수 Jay-Z의 열혈팬입니다.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/10"><span class="ico_newfriends_v1 ico_arrow"></span>제품보기</a>
                </div>
            </div>
        </div>
    </div>
    <!-- // ko -->

    <!-- en -->
    <div class="wrap_charinfo" lang="en">
        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_ryan"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_ryan">RYAN</h3>
                    <em class="desc_character">A male lion whose complex is <br class="rw_hide">his absence of a mane.</em>
                    <p class="txt_character">
                        He is often misunderstood because of his large build and impassive <br class="rw_show">
                        expression, but in fact, he has an unexpected charm with the sensitivity <br class="rw_show">
                        of a young girl! Ryan was originally the successor to the throne on <br class="rw_show">
                        Dung Dung Island in Africa, but he escaped for a life of freedom!<br class="rw_show">
                        He is the reliable advisor among the Kakao Friends. His tail is short <br class="rw_show">
                        because it would be easy for him to get caught if it was long.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/23"><span class="ico_newfriends_v1 ico_arrow"></span>See Products</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_apeach"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_apeach">APEACH</h3>
                    <em class="desc_character">Mischievous peach that escaped <br class="rw_hide">from the peach tree</em>
                    <p class="txt_character">
                        Apeach, the mischievous peach that escaped from the peach tree<br class="rw_show">
                        after finding out its condition of monoecism caused by gene mutation!<br class="rw_show">
                        Apeach charms people with its sexy back, and is quite aggressive and <br class="rw_show">
                        hot-tempered.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/6"><span class="ico_newfriends_v1 ico_arrow"></span>See Products</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_muzicon"></span>
                </div>
                <div class="area_cont">
                    <strong class="tit_character img_charInfo tit_muzicon">MUZI &amp; CON</strong>
                    <em class="desc_character">Muzi, who wears a rabbit costume, <br class="rw_hide">and the unidentifiable Con</em>
                    <p class="txt_character">
                        The curious and playful Muzi is actually a pickled radish wearing<br class="rw_show">
                        a rabbit costume! Muzi gets very shy without the rabbit costume.<br class="rw_show">
                        The unidentifiable crocodile Con created Muzi by raising a pickled radish! <br class="rw_show">
                        Now, Con wants to raise a peach and hence is searching for Apeach.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/5"><span class="ico_newfriends_v1 ico_arrow"></span>See Products</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_frodoneo"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_frodoneo">frodo&amp;neo</h3>
                    <em class="desc_character">The wealthy city dog Frodo and <br class="rw_hide">the coy fashion icon Neo</em>
                    <p class="txt_character">
                        Frodo and Neo are the official couple of the Kakao Friends, and are <br class="rw_show">
                        madly in love! Frodo, the city dog from a wealthy family, is actually a <br class="rw_show">
                        mixed breed. He has an inferiority complex about his descent.<br class="rw_show">
                        Neo, the coy feline that's bent on narcissism. She is the representative <br class="rw_show">
                        fashion icon of the district who loves shopping. However, the fact that <br class="rw_show">
                        her proud confidence is rooted in her bob 'wig' is a secret!
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/7"><span class="ico_newfriends_v1 ico_arrow"></span>See Products</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_tube"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_tube">TUBE</h3>
                    <em class="desc_character">A timid and sensitive duck</em>
                    <p class="txt_character">
                        Tube, a timid and sensitive duck. When Tube feels extreme terror, he <br class="rw_show">
                        transforms into a crazy green duck. His wears large flippers to hide his <br class="rw_show">
                        small feet. The Ugly Duckling is his distant relative.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/9"><span class="ico_newfriends_v1 ico_arrow"></span>See Products</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_jayg"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_jayg">JAY-G</h3>
                    <em class="desc_character">The free soul that loves hip hop</em>
                    <p class="txt_character">
                        Jay-G, a secret agent that is nostalgic about his underground home!<br>
                        He'd like to seem cool-headed with a clear sense of duty, but in reality is <br class="rw_show">
                        quite clumsy. Jay-G is in fact a lonely and sensitive being, unlike what his <br class="rw_show">
                        outer appearance suggests. He is a big fan of the hip hop artist Jay-Z.
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/10"><span class="ico_newfriends_v1 ico_arrow"></span>See Products</a>
                </div>
            </div>
        </div>
    </div>
    <!-- // en -->

    <!-- ja -->
    <div class="wrap_charinfo" lang="ja">
        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_ryan"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_ryan">RYAN</h3>
                    <em class="desc_character">たてがみのない牡ライオン、ライアン</em>
                    <p class="txt_character">
                        大きな体とぶっきらぼうな表情で誤解されることも多いですが、<br class="rw_show">
                        実は誰よりも心優しく繊細で乙女のような心を持ち合わせた、<br class="rw_show">
                        意外な魅力の所有者です。 元々はアフリカのぷかぷか島の王位継承者でしたが、自由な生き方にあこがれて島を抜け出しました。<br class="rw_show">
                        カカオフレンズの頼もしいアドバイザーの役割を担っています。<br class="rw_show">
                        しっぽが長いと捕まってしまうため、しっぽが短いです。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/23"><span class="ico_newfriends_v1 ico_arrow"></span>商品を見る</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_apeach"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_apeach">APEACH</h3>
                    <em class="desc_character">桃の木を抜け出した悪ガキ桃、アピーチ</em>
                    <p class="txt_character">
                        遺伝子変異で雌雄同体となったことに気づいて<br class="rw_show">
                        桃の木を抜け出した悪ガキ桃のアピーチ！<br class="rw_show">
                        セクシーな後ろ姿で見る者を惹きつけますが、<br class="rw_show">
                        性格はとてもせっかちで過激です。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/6"><span class="ico_newfriends_v1 ico_arrow"></span>商品を見る</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_muzicon"></span>
                </div>
                <div class="area_cont">
                    <strong class="tit_character img_charInfo tit_muzicon">MUZI &amp; CON</strong>
                    <em class="desc_character">ウサギの服を着ているムジと正体不明のコン、<br class="rw_hide">ムジ&コン</em>
                    <p class="txt_character">
                        好奇心旺盛ないたずらっ子ムジの正体は、実はウサギの服を着たたくあん！<br class="rw_show">
                        ウサギの服を脱ぐと恥ずかしがりになります。<br class="rw_show">
                        コンは、たくあんをムジに育て上げた正体不明のワニです。<br class="rw_show">
                        最近では桃を育てたくなり、アピーチの後を追いかけ回しています。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/5"><span class="ico_newfriends_v1 ico_arrow"></span>商品を見る</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_frodoneo"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_frodoneo">frodo&amp;neo</h3>
                    <em class="desc_character">リッチなお家の都会犬フロドと、<br class="rw_show">
                        気取り屋さん<br class="rw_hide">でファッショニスタのネオ、フロド&ネオ</em>
                    <p class="txt_character">
                        フロドとネオはカカオフレンズが誇るアツアツの公式カップルです！<br class="rw_show">
                        リッチなお家の都会犬フロドは、実は雑種。生まれに対してコンプレックスを感じています。 自分自身が一番大事な気取り屋さんの猫のネオ。<br class="rw_show">
                        ショッピングをこよなく愛する、街一番のファッショニスタです。 だけど、満ち溢れる自信の源がショートボブの「カツラ」であることは内緒！
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/7"><span class="ico_newfriends_v1 ico_arrow"></span>商品を見る</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_tube"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_tube">TUBE</h3>
                    <em class="desc_character">小心者で気の弱いアヒルのチューブ、チューブ</em>
                    <p class="txt_character">
                        小心者で気の弱いアヒルのチューブ。<br class="rw_show">
                        極度の恐怖を感じると、クレイジーアヒルに変身します。<br class="rw_show">
                        小さな足がコンプレックスなので、大きな足ヒレを履いています。<br class="rw_show">
                        みにくいあひるの子とは遠い親戚関係です。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/9"><span class="ico_newfriends_v1 ico_arrow"></span>商品を見る</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_jayg"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_jayg">JAY-G</h3>
                    <em class="desc_character">ヒップホップを愛する自由な魂、ジェイジー</em>
                    <p class="txt_character">
                        土の中にある故郷へのホームシックを常に感じているシークレット·エージェントのJAY-G！ プロ意識が強いため冷徹な男として振舞いたいのですが、内心ではきょどきょどしています。<br class="rw_show">
                        外見とは異なり、一皮むいてみると寂しがりやで繊細な感受性の持ち主。<br class="rw_show">
                        ヒップホップ歌手Jay-Zの熱烈なファンでもあります。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/10"><span class="ico_newfriends_v1 ico_arrow"></span>商品を見る</a>
                </div>
            </div>
        </div>
    </div>
    <!-- // ja -->

    <!-- zh-Hans -->
    <div class="wrap_charinfo" lang="zh-Hans">
        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_ryan"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_ryan">RYAN</h3>
                    <em class="desc_character">因为没有鬃毛而感到自卑的雄狮</em>
                    <p class="txt_character">
                        因为大块头和木讷的表情而经常被误会，<br class="rw_show">
                        其实却像少女一样比任何人都细腻、敏感，是个充满反差魅力的角色！<br class="rw_show">
                        原本是非洲东东岛的王位继承者，因为向往自由的人生而逃离岛上！<br class="rw_show">
                        目前担任 Kakao Friends 最可靠的指导者。<br class="rw_show">
                        尾巴太长容易被抓到，所以尾巴很短。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/23"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品细节</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_apeach"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_apeach">APEACH</h3>
                    <em class="desc_character">逃离了桃树的恶童桃子</em>
                    <p class="txt_character">
                        知道自己因为基因突变而雌雄同体，逃离了桃树的恶童桃子Apeach！<br class="rw_show">
                        总是用性感的背影吸引人们，但个性很急很激进。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/6"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品细节</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_muzicon"></span>
                </div>
                <div class="area_cont">
                    <strong class="tit_character img_charInfo tit_muzicon">MUZI &amp; CON</strong>
                    <em class="desc_character">穿着兔子外衣的Muzi与真实身分不明的Con</em>
                    <p class="txt_character">
                        充满好奇心的淘气宝宝Muzi的真实身分，其实是穿着兔子外衣的腌萝卜！ 脱下兔子外衣就会让它非常害羞。<br class="rw_show">
                        把腌萝卜养大变成Muzi的，则是真实身分成谜的鳄鱼Con！<br class="rw_show">
                        它现在想要养桃子，所以到处寻找Apeach。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/5"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品细节</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_frodoneo"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_frodoneo">frodo&amp;neo</h3>
                    <em class="desc_character">住在城市里的富家狗Frodo<br class="rw_hide">与喜欢装模作样的时尚明星Neo</em>
                    <p class="txt_character">
                        Frodo 与 Neo 是 Kakao Friends 官方认证的情侣，甜甜蜜蜜放闪中！<br class="rw_show">
                        住在城市里的富家狗 Frodo 其实并不是纯种狗，对此它感到非常自卑。而爱装模作样的 Neo 则是最自恋的猫。<br class="rw_show">
                        喜欢购物的它，是最能代表这一区的时尚明星。不过让它能超有自信的短发，其实是顶“假发”的事情则是最大的秘密！
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/7"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品细节</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_tube"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_tube">TUBE</h3>
                    <em class="desc_character">胆小玻璃心的鸭子</em>
                    <p class="txt_character">
                        胆小玻璃心的鸭子，Tube。<br class="rw_show">
                        感受到强烈的恐惧时，就会变身成为疯狂鸭。因为脚很小而感到自卑，所以总是穿着大大的鸭脚鞋。跟丑小鸭是远亲。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/9"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品细节</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_jayg"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_jayg">JAY-G</h3>
                    <em class="desc_character">热爱嘻哈的自由灵魂</em>
                    <p class="txt_character">
                        非常思念地底故乡的秘密探员，Jay-G！<br>
                        希望让人感觉信念明确、冷静睿智，但其实有点傻。<br class="rw_show">
                        跟外表不同，深入了解会发现他很怕孤单、非常感性。<br class="rw_show">
                        是嘻哈歌手Jay-Z狂粉。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/10"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品细节</a>
                </div>
            </div>
        </div>
    </div>
    <!-- // zh-Hans -->

    <!-- zh-Hant -->
    <div class="wrap_charinfo" lang="zh-Hant">
        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_ryan"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_ryan">RYAN</h3>
                    <em class="desc_character">因為沒有鬃毛而感到自卑的雄獅</em>
                    <p class="txt_character">
                        因為大塊頭和木訥的表情而經常被誤會，<br class="rw_show">
                        其實卻像少女一樣比人都纖細、敏感，是個充滿反差魅力的角色！<br class="rw_show">
                        原本是非洲東東島的王位繼承者，因為嚮往自由的人生而逃離島上！<br class="rw_show">
                        目前擔任Kakao Friends最可靠的指導者。<br class="rw_show">
                        尾巴要是太長的話就會被抓到，所以尾巴很短。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/23"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品細節</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_apeach"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_apeach">APEACH</h3>
                    <em class="desc_character">逃離了桃樹的惡童桃子</em>
                    <p class="txt_character">
                        知道自己因為基因突變而雌雄同體，逃離了桃樹的惡童桃子Apeach！<br class="rw_show">
                        總是用性感的背影吸引人們，但個性很急很激進。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/6"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品細節</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_muzicon"></span>
                </div>
                <div class="area_cont">
                    <strong class="tit_character img_charInfo tit_muzicon">MUZI &amp; CON</strong>
                    <em class="desc_character">穿着兔子外衣的Muzi与真实身分不明的Con</em>
                    <p class="txt_character">
                        充滿好奇心的淘氣寶寶Muzi的真實身分，<br class="rw_show">
                        其實是穿著兔子外衣的醃蘿蔔！脫下兔子外衣就會讓他非常害羞。<br class="rw_show">
                        把醃黃蘿蔔養大變成Muzi的，則是真實身分成謎的鱷魚Con！<br class="rw_show">
                        他現在想要養桃子，所以到處尋找Apeach。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/5"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品細節</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_frodoneo"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_frodoneo">frodo&amp;neo</h3>
                    <em class="desc_character">住在都市裡的富家狗Frodo<br class="rw_hide">與喜歡裝模作樣的時尚明星Neo</em>
                    <p class="txt_character">
                        Frodo與Neo是Kakao Friends官方認證的情侶，甜甜蜜蜜放閃中！<br class="rw_show">
                        住在都市裡的富家狗Frodo其實並不是純種狗，對此他感到非常自卑。<br class="rw_show">
                        而愛裝模作樣的Neo則是最自戀的貓。 喜歡購物的她，是最能代表這一區的時尚明星。 不過讓她能超有自信的短髮，其實是頂「假髮」的事情則是最大的秘密！
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/7"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品細節</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_tube"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_tube">TUBE</h3>
                    <em class="desc_character">膽小玻璃心的鴨子</em>
                    <p class="txt_character">
                        膽小玻璃心的鴨子，Tube。<br class="rw_show">
                        感受到強烈的恐懼時，就會變身成為瘋狂鴨子。<br class="rw_show">
                        因為腳很小而感到自卑，所以總是穿著大大的鴨腳鞋。<br class="rw_show">
                        跟醜小鴨是遠親。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/9"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品細節</a>
                </div>
            </div>
        </div>

        <div class="section_charinfo">
            <div class="inner_character">
                <div class="area_img">
                    <span class="img_charInfo ico_jayg"></span>
                </div>
                <div class="area_cont">
                    <h3 class="tit_character img_charInfo tit_jayg">JAY-G</h3>
                    <em class="desc_character">熱愛嘻哈的自由靈魂</em>
                    <p class="txt_character">
                        非常思念地底故鄉的秘密探員，Jay-G！<br>
                        希望讓人感覺信念明確、冷靜睿智，但其實有點傻。<br class="rw_show">
                        跟外表不同，深入了解會發現他很怕孤單、非常感性。<br class="rw_show">
                        是嘻哈歌手Jay-Z狂粉。
                    </p>
                    <a class="link_view" href="${reqPath}/kr/products/groups/characters/10"><span class="ico_newfriends_v1 ico_arrow"></span>查看商品細節</a>
                </div>
            </div>
        </div>
    </div>
    <!-- // zh-Hant -->
</div>