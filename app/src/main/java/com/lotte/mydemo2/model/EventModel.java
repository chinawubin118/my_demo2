package com.lotte.mydemo2.model;

/**
 * Created by Administrator on 2017/1/9.
 */

public class EventModel {
    public static class BaseEvent {
        private int eventCode;//事件代码(17010901 年月日+两位数字)

        public int getEventCode() {
            return eventCode;
        }

        public void setEventCode(int eventCode) {
            this.eventCode = eventCode;
        }
    }

    public static class Event1 extends BaseEvent {
        private String eventStr = "";

        public Event1(String eventStr) {
            this.eventStr = eventStr;
        }

        public String getEventStr() {
            return eventStr;
        }

        public void setEventStr(String eventStr) {
            this.eventStr = eventStr;
        }
    }
}
