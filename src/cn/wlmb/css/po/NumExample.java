package cn.wlmb.css.po;

import java.util.ArrayList;
import java.util.List;

public class NumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NumExample() {
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

        public Criteria andNowquerynumIsNull() {
            addCriterion("nowquerynum is null");
            return (Criteria) this;
        }

        public Criteria andNowquerynumIsNotNull() {
            addCriterion("nowquerynum is not null");
            return (Criteria) this;
        }

        public Criteria andNowquerynumEqualTo(Long value) {
            addCriterion("nowquerynum =", value, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumNotEqualTo(Long value) {
            addCriterion("nowquerynum <>", value, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumGreaterThan(Long value) {
            addCriterion("nowquerynum >", value, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumGreaterThanOrEqualTo(Long value) {
            addCriterion("nowquerynum >=", value, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumLessThan(Long value) {
            addCriterion("nowquerynum <", value, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumLessThanOrEqualTo(Long value) {
            addCriterion("nowquerynum <=", value, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumIn(List<Long> values) {
            addCriterion("nowquerynum in", values, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumNotIn(List<Long> values) {
            addCriterion("nowquerynum not in", values, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumBetween(Long value1, Long value2) {
            addCriterion("nowquerynum between", value1, value2, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowquerynumNotBetween(Long value1, Long value2) {
            addCriterion("nowquerynum not between", value1, value2, "nowquerynum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumIsNull() {
            addCriterion("nowwaitnum is null");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumIsNotNull() {
            addCriterion("nowwaitnum is not null");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumEqualTo(Long value) {
            addCriterion("nowwaitnum =", value, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumNotEqualTo(Long value) {
            addCriterion("nowwaitnum <>", value, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumGreaterThan(Long value) {
            addCriterion("nowwaitnum >", value, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumGreaterThanOrEqualTo(Long value) {
            addCriterion("nowwaitnum >=", value, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumLessThan(Long value) {
            addCriterion("nowwaitnum <", value, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumLessThanOrEqualTo(Long value) {
            addCriterion("nowwaitnum <=", value, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumIn(List<Long> values) {
            addCriterion("nowwaitnum in", values, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumNotIn(List<Long> values) {
            addCriterion("nowwaitnum not in", values, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumBetween(Long value1, Long value2) {
            addCriterion("nowwaitnum between", value1, value2, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andNowwaitnumNotBetween(Long value1, Long value2) {
            addCriterion("nowwaitnum not between", value1, value2, "nowwaitnum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumIsNull() {
            addCriterion("onlineservernum is null");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumIsNotNull() {
            addCriterion("onlineservernum is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumEqualTo(Long value) {
            addCriterion("onlineservernum =", value, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumNotEqualTo(Long value) {
            addCriterion("onlineservernum <>", value, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumGreaterThan(Long value) {
            addCriterion("onlineservernum >", value, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumGreaterThanOrEqualTo(Long value) {
            addCriterion("onlineservernum >=", value, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumLessThan(Long value) {
            addCriterion("onlineservernum <", value, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumLessThanOrEqualTo(Long value) {
            addCriterion("onlineservernum <=", value, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumIn(List<Long> values) {
            addCriterion("onlineservernum in", values, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumNotIn(List<Long> values) {
            addCriterion("onlineservernum not in", values, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumBetween(Long value1, Long value2) {
            addCriterion("onlineservernum between", value1, value2, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andOnlineservernumNotBetween(Long value1, Long value2) {
            addCriterion("onlineservernum not between", value1, value2, "onlineservernum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumIsNull() {
            addCriterion("allchatnum is null");
            return (Criteria) this;
        }

        public Criteria andAllchatnumIsNotNull() {
            addCriterion("allchatnum is not null");
            return (Criteria) this;
        }

        public Criteria andAllchatnumEqualTo(Long value) {
            addCriterion("allchatnum =", value, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumNotEqualTo(Long value) {
            addCriterion("allchatnum <>", value, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumGreaterThan(Long value) {
            addCriterion("allchatnum >", value, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumGreaterThanOrEqualTo(Long value) {
            addCriterion("allchatnum >=", value, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumLessThan(Long value) {
            addCriterion("allchatnum <", value, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumLessThanOrEqualTo(Long value) {
            addCriterion("allchatnum <=", value, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumIn(List<Long> values) {
            addCriterion("allchatnum in", values, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumNotIn(List<Long> values) {
            addCriterion("allchatnum not in", values, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumBetween(Long value1, Long value2) {
            addCriterion("allchatnum between", value1, value2, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAllchatnumNotBetween(Long value1, Long value2) {
            addCriterion("allchatnum not between", value1, value2, "allchatnum");
            return (Criteria) this;
        }

        public Criteria andAvgokIsNull() {
            addCriterion("avgok is null");
            return (Criteria) this;
        }

        public Criteria andAvgokIsNotNull() {
            addCriterion("avgok is not null");
            return (Criteria) this;
        }

        public Criteria andAvgokEqualTo(Double value) {
            addCriterion("avgok =", value, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokNotEqualTo(Double value) {
            addCriterion("avgok <>", value, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokGreaterThan(Double value) {
            addCriterion("avgok >", value, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokGreaterThanOrEqualTo(Double value) {
            addCriterion("avgok >=", value, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokLessThan(Double value) {
            addCriterion("avgok <", value, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokLessThanOrEqualTo(Double value) {
            addCriterion("avgok <=", value, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokIn(List<Double> values) {
            addCriterion("avgok in", values, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokNotIn(List<Double> values) {
            addCriterion("avgok not in", values, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokBetween(Double value1, Double value2) {
            addCriterion("avgok between", value1, value2, "avgok");
            return (Criteria) this;
        }

        public Criteria andAvgokNotBetween(Double value1, Double value2) {
            addCriterion("avgok not between", value1, value2, "avgok");
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