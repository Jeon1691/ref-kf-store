package com.kakaofriends.front.utils;

import com.kakaofriends.front.common.event.GlobalEmsEvent;
import com.kakaofriends.front.domain.BoxItem;

import java.util.*;

/**
 * Created by Dave on 2017. 4. 25..
 */
public class BoxUtil {

    public Map<String, BoxItem> boxMap = new HashMap<>();

    public void boxInit() {
        // 키가 박스 호수
        boxMap.put("2", new BoxItem(270, 180, 150, 138));
        boxMap.put("4", new BoxItem(410, 310, 280, 392));
        boxMap.put("6", new BoxItem(570, 445, 300, 701));
    }

    public ArrayList<BoxItem> getBoxs (LinkedList<BoxItem> orderItemList, String orderMainPk) {
        if(boxMap.isEmpty()){
            boxInit();
        }

        BoxItem workBox = null;
        ArrayList<BoxItem> boxs = new ArrayList<>();
        LinkedList<BoxItem> tempList = new LinkedList<>();
        Collections.sort(orderItemList);

        while (orderItemList.size() > 0 || tempList.size() > 0) {

            if(tempList.size() > 0) {
                orderItemList.addAll(tempList);
                tempList.clear();
            }

            if (workBox == null) {
                while (true){
                    String key = findBox(boxMap, orderItemList);

                    // 박스를 찾았다면 loop 빠져나가기
                    if(key != null){
                        workBox = new BoxItem(boxMap.get(key), key,boxs.size() + 1,  orderMainPk);
                        boxs.add(workBox);
                        break;
                    }

                    // 가장 작은 아이템 빼기
                    Collections.sort(orderItemList);

                    // 사은품 이벤트: 가장 작은 상품이 사은품이면 다음으로 작은 상품을 뺌
                    GlobalEmsEvent globalEmsEvent = new GlobalEmsEvent();
                    if(globalEmsEvent.isEventProduct(orderItemList.get(0).getProductCode())){
                        tempList.add(orderItemList.remove(1));
                        continue;
                    }

                    tempList.add(orderItemList.remove(0));
                }
            }

            // 박스에 item insert
            while (orderItemList.size() > 0){
                workBox.sort();
                workBox.insertBox(orderItemList.get(0));
                orderItemList.remove(orderItemList.get(0));
            }

            workBox = null;
        }

        return boxs;
    }

    public double getTotalVolume(LinkedList<BoxItem> objList){
        double totVolume = 0;
        for(BoxItem item : objList){
            totVolume += item.getSize().get(0) * item.getSize().get(1) * item.getSize().get(2);
        }

        return totVolume;
    }

    public String findBox(Map<String, BoxItem > map, LinkedList<BoxItem> objList ){
        double totVolume = getTotalVolume(objList);

        TreeSet<String> treeSet = new TreeSet<>(map.keySet());
        Iterator<String> keyItr = treeSet.iterator();
        String key = null;

        while (keyItr.hasNext()){
            String keyIndex = keyItr.next();
            BoxItem orgBox = map.get(keyIndex);

            //포장 후 남은 아이템 중 가장 길이가 긴 값 체크
            double maxItemSize = 0;
            for (BoxItem item : objList) {
                if (maxItemSize < item.getSize().get(0)) {
                    maxItemSize = item.getSize().get(0);
                }
            }

            if(map.get(keyIndex).isInsertPossible(orgBox, totVolume, maxItemSize)){
                key = keyIndex;
                return key;
            }
        }

        // 맞는 사이즈에 박스를 찾지 못했고 남은 아이템 수가 한가지면 6호 박스에 넣기
        if(key == null && objList.size() == 1){
            key = "6";
        }

        // 사은품 이벤트 : 맞는 사이즈에 박스를 찾지 못했고 남은 아이템 수가 사은품을 포함한 두가지면 6호박스에 넣기
        if(key == null && objList.size() == 2){
            GlobalEmsEvent globalEmsEvent = new GlobalEmsEvent();
            for(BoxItem item : objList){
                if(globalEmsEvent.isEventProduct(item.getProductCode())){
                    key = "6";
                }
            }
        }

        return key;
    }

}
