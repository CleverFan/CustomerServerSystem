package cn.wlmb.css.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServermsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServermsgExample() {
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
            addCriterion("serverid is null");
            return (Criteria) this;
        }

        public Criteria andServeridIsNotNull() {
            addCriterion("serverid is not null");
            return (Criteria) this;
        }

        public Criteria andServeridEqualTo(String value) {
            addCriterion("serverid =", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotEqualTo(String value) {
            addCriterion("serverid <>", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridGreaterThan(String value) {
            addCriterion("serverid >", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridGreaterThanOrEqualTo(String value) {
            addCriterion("serverid >=", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridLessThan(String value) {
            addCriterion("serverid <", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridLessThanOrEqualTo(String value) {
            addCriterion("serverid <=", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridLike(String value) {
            addCriterion("serverid like", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotLike(String value) {
            addCriterion("serverid not like", value, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridIn(List<String> values) {
            addCriterion("serverid in", values, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotIn(List<String> values) {
            addCriterion("serverid not in", values, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridBetween(String value1, String value2) {
            addCriterion("serverid between", value1, value2, "serverid");
            return (Criteria) this;
        }

        public Criteria andServeridNotBetween(String value1, String value2) {
            addCriterion("serverid not between", value1, value2, "serverid");
            return (Criteria) this;
        }

        public Criteria andMsgnumIsNull() {
            addCriterion("msgnum is null");
            return (Criteria) this;
        }

        public Criteria andMsgnumIsNotNull() {
            addCriterion("msgnum is not null");
            return (Criteria) this;
        }

        public Criteria andMsgnumEqualTo(Long value) {
            addCriterion("msgnum =", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumNotEqualTo(Long value) {
            addCriterion("msgnum <>", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumGreaterThan(Long value) {
            addCriterion("msgnum >", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumGreaterThanOrEqualTo(Long value) {
            addCriterion("msgnum >=", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumLessThan(Long value) {
            addCriterion("msgnum <", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumLessThanOrEqualTo(Long value) {
            addCriterion("msgnum <=", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumIn(List<Long> values) {
            addCriterion("msgnum in", values, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumNotIn(List<Long> values) {
            addCriterion("msgnum not in", values, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumBetween(Long value1, Long value2) {
            addCriterion("msgnum between", value1, value2, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumNotBetween(Long value1, Long value2) {
            addCriterion("msgnum not between", value1, value2, "msgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumIsNull() {
            addCriterion("servermsgnum is null");
            return (Criteria) this;
        }

        public Criteria andServermsgnumIsNotNull() {
            addCriterion("servermsgnum is not null");
            return (Criteria) this;
        }

        public Criteria andServermsgnumEqualTo(BigDecimal value) {
            addCriterion("servermsgnum =", value, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumNotEqualTo(BigDecimal value) {
            addCriterion("servermsgnum <>", value, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumGreaterThan(BigDecimal value) {
            addCriterion("servermsgnum >", value, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("servermsgnum >=", value, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumLessThan(BigDecimal value) {
            addCriterion("servermsgnum <", value, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("servermsgnum <=", value, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumIn(List<BigDecimal> values) {
            addCriterion("servermsgnum in", values, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumNotIn(List<BigDecimal> values) {
            addCriterion("servermsgnum not in", values, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("servermsgnum between", value1, value2, "servermsgnum");
            return (Criteria) this;
        }

        public Criteria andServermsgnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("servermsgnum not between", value1, value2, "servermsgnum");
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