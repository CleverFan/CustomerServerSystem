package cn.wlmb.css.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andChatidIsNull() {
            addCriterion("chatID is null");
            return (Criteria) this;
        }

        public Criteria andChatidIsNotNull() {
            addCriterion("chatID is not null");
            return (Criteria) this;
        }

        public Criteria andChatidEqualTo(String value) {
            addCriterion("chatID =", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidNotEqualTo(String value) {
            addCriterion("chatID <>", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidGreaterThan(String value) {
            addCriterion("chatID >", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidGreaterThanOrEqualTo(String value) {
            addCriterion("chatID >=", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidLessThan(String value) {
            addCriterion("chatID <", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidLessThanOrEqualTo(String value) {
            addCriterion("chatID <=", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidLike(String value) {
            addCriterion("chatID like", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidNotLike(String value) {
            addCriterion("chatID not like", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidIn(List<String> values) {
            addCriterion("chatID in", values, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidNotIn(List<String> values) {
            addCriterion("chatID not in", values, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidBetween(String value1, String value2) {
            addCriterion("chatID between", value1, value2, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidNotBetween(String value1, String value2) {
            addCriterion("chatID not between", value1, value2, "chatid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNull() {
            addCriterion("customerID is null");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNotNull() {
            addCriterion("customerID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomeridEqualTo(String value) {
            addCriterion("customerID =", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotEqualTo(String value) {
            addCriterion("customerID <>", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThan(String value) {
            addCriterion("customerID >", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("customerID >=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThan(String value) {
            addCriterion("customerID <", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThanOrEqualTo(String value) {
            addCriterion("customerID <=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLike(String value) {
            addCriterion("customerID like", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotLike(String value) {
            addCriterion("customerID not like", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIn(List<String> values) {
            addCriterion("customerID in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotIn(List<String> values) {
            addCriterion("customerID not in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridBetween(String value1, String value2) {
            addCriterion("customerID between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotBetween(String value1, String value2) {
            addCriterion("customerID not between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andServeridIsNull() {
            addCriterion("serverID is null");
            return (Criteria) this;
        }

        public Criteria andServeridIsNotNull() {
            addCriterion("serverID is not null");
            return (Criteria) this;
        }

        public Criteria andServeridEqualTo(String value) {
            addCriterion("serverID =", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotEqualTo(String value) {
            addCriterion("serverID <>", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridGreaterThan(String value) {
            addCriterion("serverID >", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridGreaterThanOrEqualTo(String value) {
            addCriterion("serverID >=", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridLessThan(String value) {
            addCriterion("serverID <", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridLessThanOrEqualTo(String value) {
            addCriterion("serverID <=", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridLike(String value) {
            addCriterion("serverID like", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotLike(String value) {
            addCriterion("serverID not like", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridIn(List<String> values) {
            addCriterion("serverID in", values, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotIn(List<String> values) {
            addCriterion("serverID not in", values, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridBetween(String value1, String value2) {
            addCriterion("serverID between", value1, value2, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotBetween(String value1, String value2) {
            addCriterion("serverID not between", value1, value2, "serverid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNull() {
            addCriterion("overtime is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeIsNotNull() {
            addCriterion("overtime is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeEqualTo(Date value) {
            addCriterion("overtime =", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotEqualTo(Date value) {
            addCriterion("overtime <>", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThan(Date value) {
            addCriterion("overtime >", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("overtime >=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThan(Date value) {
            addCriterion("overtime <", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeLessThanOrEqualTo(Date value) {
            addCriterion("overtime <=", value, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeIn(List<Date> values) {
            addCriterion("overtime in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotIn(List<Date> values) {
            addCriterion("overtime not in", values, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeBetween(Date value1, Date value2) {
            addCriterion("overtime between", value1, value2, "overtime");
            return (Criteria) this;
        }

        public Criteria andOvertimeNotBetween(Date value1, Date value2) {
            addCriterion("overtime not between", value1, value2, "overtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}