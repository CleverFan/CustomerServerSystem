package cn.wlmb.css.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServerExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNull() {
            addCriterion("headimg is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNotNull() {
            addCriterion("headimg is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgEqualTo(String value) {
            addCriterion("headimg =", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotEqualTo(String value) {
            addCriterion("headimg <>", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThan(String value) {
            addCriterion("headimg >", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("headimg >=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThan(String value) {
            addCriterion("headimg <", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThanOrEqualTo(String value) {
            addCriterion("headimg <=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLike(String value) {
            addCriterion("headimg like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotLike(String value) {
            addCriterion("headimg not like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgIn(List<String> values) {
            addCriterion("headimg in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotIn(List<String> values) {
            addCriterion("headimg not in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgBetween(String value1, String value2) {
            addCriterion("headimg between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotBetween(String value1, String value2) {
            addCriterion("headimg not between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeIsNull() {
            addCriterion("ser_creatime is null");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeIsNotNull() {
            addCriterion("ser_creatime is not null");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeEqualTo(Date value) {
            addCriterion("ser_creatime =", value, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeNotEqualTo(Date value) {
            addCriterion("ser_creatime <>", value, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeGreaterThan(Date value) {
            addCriterion("ser_creatime >", value, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ser_creatime >=", value, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeLessThan(Date value) {
            addCriterion("ser_creatime <", value, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeLessThanOrEqualTo(Date value) {
            addCriterion("ser_creatime <=", value, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeIn(List<Date> values) {
            addCriterion("ser_creatime in", values, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeNotIn(List<Date> values) {
            addCriterion("ser_creatime not in", values, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeBetween(Date value1, Date value2) {
            addCriterion("ser_creatime between", value1, value2, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andSerCreatimeNotBetween(Date value1, Date value2) {
            addCriterion("ser_creatime not between", value1, value2, "serCreatime");
            return (Criteria) this;
        }

        public Criteria andMaskIsNull() {
            addCriterion("mask is null");
            return (Criteria) this;
        }

        public Criteria andMaskIsNotNull() {
            addCriterion("mask is not null");
            return (Criteria) this;
        }

        public Criteria andMaskEqualTo(Double value) {
            addCriterion("mask =", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskNotEqualTo(Double value) {
            addCriterion("mask <>", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskGreaterThan(Double value) {
            addCriterion("mask >", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskGreaterThanOrEqualTo(Double value) {
            addCriterion("mask >=", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskLessThan(Double value) {
            addCriterion("mask <", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskLessThanOrEqualTo(Double value) {
            addCriterion("mask <=", value, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskIn(List<Double> values) {
            addCriterion("mask in", values, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskNotIn(List<Double> values) {
            addCriterion("mask not in", values, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskBetween(Double value1, Double value2) {
            addCriterion("mask between", value1, value2, "mask");
            return (Criteria) this;
        }

        public Criteria andMaskNotBetween(Double value1, Double value2) {
            addCriterion("mask not between", value1, value2, "mask");
            return (Criteria) this;
        }

        public Criteria andPersonnumIsNull() {
            addCriterion("personNum is null");
            return (Criteria) this;
        }

        public Criteria andPersonnumIsNotNull() {
            addCriterion("personNum is not null");
            return (Criteria) this;
        }

        public Criteria andPersonnumEqualTo(Integer value) {
            addCriterion("personNum =", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumNotEqualTo(Integer value) {
            addCriterion("personNum <>", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumGreaterThan(Integer value) {
            addCriterion("personNum >", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("personNum >=", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumLessThan(Integer value) {
            addCriterion("personNum <", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumLessThanOrEqualTo(Integer value) {
            addCriterion("personNum <=", value, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumIn(List<Integer> values) {
            addCriterion("personNum in", values, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumNotIn(List<Integer> values) {
            addCriterion("personNum not in", values, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumBetween(Integer value1, Integer value2) {
            addCriterion("personNum between", value1, value2, "personnum");
            return (Criteria) this;
        }

        public Criteria andPersonnumNotBetween(Integer value1, Integer value2) {
            addCriterion("personNum not between", value1, value2, "personnum");
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