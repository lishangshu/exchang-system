package com.fuxi.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExchangeDomainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExchangeDomainExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainHashIsNull() {
            addCriterion("domain_hash is null");
            return (Criteria) this;
        }

        public Criteria andDomainHashIsNotNull() {
            addCriterion("domain_hash is not null");
            return (Criteria) this;
        }

        public Criteria andDomainHashEqualTo(String value) {
            addCriterion("domain_hash =", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashNotEqualTo(String value) {
            addCriterion("domain_hash <>", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashGreaterThan(String value) {
            addCriterion("domain_hash >", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashGreaterThanOrEqualTo(String value) {
            addCriterion("domain_hash >=", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashLessThan(String value) {
            addCriterion("domain_hash <", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashLessThanOrEqualTo(String value) {
            addCriterion("domain_hash <=", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashLike(String value) {
            addCriterion("domain_hash like", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashNotLike(String value) {
            addCriterion("domain_hash not like", value, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashIn(List<String> values) {
            addCriterion("domain_hash in", values, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashNotIn(List<String> values) {
            addCriterion("domain_hash not in", values, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashBetween(String value1, String value2) {
            addCriterion("domain_hash between", value1, value2, "domainHash");
            return (Criteria) this;
        }

        public Criteria andDomainHashNotBetween(String value1, String value2) {
            addCriterion("domain_hash not between", value1, value2, "domainHash");
            return (Criteria) this;
        }

        public Criteria andHashCodeIsNull() {
            addCriterion("hash_code is null");
            return (Criteria) this;
        }

        public Criteria andHashCodeIsNotNull() {
            addCriterion("hash_code is not null");
            return (Criteria) this;
        }

        public Criteria andHashCodeEqualTo(String value) {
            addCriterion("hash_code =", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeNotEqualTo(String value) {
            addCriterion("hash_code <>", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeGreaterThan(String value) {
            addCriterion("hash_code >", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeGreaterThanOrEqualTo(String value) {
            addCriterion("hash_code >=", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeLessThan(String value) {
            addCriterion("hash_code <", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeLessThanOrEqualTo(String value) {
            addCriterion("hash_code <=", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeLike(String value) {
            addCriterion("hash_code like", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeNotLike(String value) {
            addCriterion("hash_code not like", value, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeIn(List<String> values) {
            addCriterion("hash_code in", values, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeNotIn(List<String> values) {
            addCriterion("hash_code not in", values, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeBetween(String value1, String value2) {
            addCriterion("hash_code between", value1, value2, "hashCode");
            return (Criteria) this;
        }

        public Criteria andHashCodeNotBetween(String value1, String value2) {
            addCriterion("hash_code not between", value1, value2, "hashCode");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNull() {
            addCriterion("mail_address is null");
            return (Criteria) this;
        }

        public Criteria andMailAddressIsNotNull() {
            addCriterion("mail_address is not null");
            return (Criteria) this;
        }

        public Criteria andMailAddressEqualTo(String value) {
            addCriterion("mail_address =", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotEqualTo(String value) {
            addCriterion("mail_address <>", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThan(String value) {
            addCriterion("mail_address >", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mail_address >=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThan(String value) {
            addCriterion("mail_address <", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLessThanOrEqualTo(String value) {
            addCriterion("mail_address <=", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressLike(String value) {
            addCriterion("mail_address like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotLike(String value) {
            addCriterion("mail_address not like", value, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressIn(List<String> values) {
            addCriterion("mail_address in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotIn(List<String> values) {
            addCriterion("mail_address not in", values, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressBetween(String value1, String value2) {
            addCriterion("mail_address between", value1, value2, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMailAddressNotBetween(String value1, String value2) {
            addCriterion("mail_address not between", value1, value2, "mailAddress");
            return (Criteria) this;
        }

        public Criteria andMaillNoIsNull() {
            addCriterion("maill_no is null");
            return (Criteria) this;
        }

        public Criteria andMaillNoIsNotNull() {
            addCriterion("maill_no is not null");
            return (Criteria) this;
        }

        public Criteria andMaillNoEqualTo(String value) {
            addCriterion("maill_no =", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoNotEqualTo(String value) {
            addCriterion("maill_no <>", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoGreaterThan(String value) {
            addCriterion("maill_no >", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoGreaterThanOrEqualTo(String value) {
            addCriterion("maill_no >=", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoLessThan(String value) {
            addCriterion("maill_no <", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoLessThanOrEqualTo(String value) {
            addCriterion("maill_no <=", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoLike(String value) {
            addCriterion("maill_no like", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoNotLike(String value) {
            addCriterion("maill_no not like", value, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoIn(List<String> values) {
            addCriterion("maill_no in", values, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoNotIn(List<String> values) {
            addCriterion("maill_no not in", values, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoBetween(String value1, String value2) {
            addCriterion("maill_no between", value1, value2, "maillNo");
            return (Criteria) this;
        }

        public Criteria andMaillNoNotBetween(String value1, String value2) {
            addCriterion("maill_no not between", value1, value2, "maillNo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNull() {
            addCriterion("customer_address is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNotNull() {
            addCriterion("customer_address is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressEqualTo(String value) {
            addCriterion("customer_address =", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotEqualTo(String value) {
            addCriterion("customer_address <>", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThan(String value) {
            addCriterion("customer_address >", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("customer_address >=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThan(String value) {
            addCriterion("customer_address <", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThanOrEqualTo(String value) {
            addCriterion("customer_address <=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLike(String value) {
            addCriterion("customer_address like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotLike(String value) {
            addCriterion("customer_address not like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIn(List<String> values) {
            addCriterion("customer_address in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotIn(List<String> values) {
            addCriterion("customer_address not in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressBetween(String value1, String value2) {
            addCriterion("customer_address between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotBetween(String value1, String value2) {
            addCriterion("customer_address not between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andContentItemsIsNull() {
            addCriterion("content_items is null");
            return (Criteria) this;
        }

        public Criteria andContentItemsIsNotNull() {
            addCriterion("content_items is not null");
            return (Criteria) this;
        }

        public Criteria andContentItemsEqualTo(Integer value) {
            addCriterion("content_items =", value, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsNotEqualTo(Integer value) {
            addCriterion("content_items <>", value, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsGreaterThan(Integer value) {
            addCriterion("content_items >", value, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_items >=", value, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsLessThan(Integer value) {
            addCriterion("content_items <", value, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsLessThanOrEqualTo(Integer value) {
            addCriterion("content_items <=", value, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsIn(List<Integer> values) {
            addCriterion("content_items in", values, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsNotIn(List<Integer> values) {
            addCriterion("content_items not in", values, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsBetween(Integer value1, Integer value2) {
            addCriterion("content_items between", value1, value2, "contentItems");
            return (Criteria) this;
        }

        public Criteria andContentItemsNotBetween(Integer value1, Integer value2) {
            addCriterion("content_items not between", value1, value2, "contentItems");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportIsNull() {
            addCriterion("wi_registrar_support is null");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportIsNotNull() {
            addCriterion("wi_registrar_support is not null");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportEqualTo(String value) {
            addCriterion("wi_registrar_support =", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportNotEqualTo(String value) {
            addCriterion("wi_registrar_support <>", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportGreaterThan(String value) {
            addCriterion("wi_registrar_support >", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportGreaterThanOrEqualTo(String value) {
            addCriterion("wi_registrar_support >=", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportLessThan(String value) {
            addCriterion("wi_registrar_support <", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportLessThanOrEqualTo(String value) {
            addCriterion("wi_registrar_support <=", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportLike(String value) {
            addCriterion("wi_registrar_support like", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportNotLike(String value) {
            addCriterion("wi_registrar_support not like", value, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportIn(List<String> values) {
            addCriterion("wi_registrar_support in", values, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportNotIn(List<String> values) {
            addCriterion("wi_registrar_support not in", values, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportBetween(String value1, String value2) {
            addCriterion("wi_registrar_support between", value1, value2, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiRegistrarSupportNotBetween(String value1, String value2) {
            addCriterion("wi_registrar_support not between", value1, value2, "wiRegistrarSupport");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeIsNull() {
            addCriterion("wi_create_time is null");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeIsNotNull() {
            addCriterion("wi_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeEqualTo(String value) {
            addCriterion("wi_create_time =", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeNotEqualTo(String value) {
            addCriterion("wi_create_time <>", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeGreaterThan(String value) {
            addCriterion("wi_create_time >", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("wi_create_time >=", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeLessThan(String value) {
            addCriterion("wi_create_time <", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("wi_create_time <=", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeLike(String value) {
            addCriterion("wi_create_time like", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeNotLike(String value) {
            addCriterion("wi_create_time not like", value, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeIn(List<String> values) {
            addCriterion("wi_create_time in", values, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeNotIn(List<String> values) {
            addCriterion("wi_create_time not in", values, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeBetween(String value1, String value2) {
            addCriterion("wi_create_time between", value1, value2, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiCreateTimeNotBetween(String value1, String value2) {
            addCriterion("wi_create_time not between", value1, value2, "wiCreateTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeIsNull() {
            addCriterion("wi_expiration_time is null");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeIsNotNull() {
            addCriterion("wi_expiration_time is not null");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeEqualTo(String value) {
            addCriterion("wi_expiration_time =", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeNotEqualTo(String value) {
            addCriterion("wi_expiration_time <>", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeGreaterThan(String value) {
            addCriterion("wi_expiration_time >", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("wi_expiration_time >=", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeLessThan(String value) {
            addCriterion("wi_expiration_time <", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeLessThanOrEqualTo(String value) {
            addCriterion("wi_expiration_time <=", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeLike(String value) {
            addCriterion("wi_expiration_time like", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeNotLike(String value) {
            addCriterion("wi_expiration_time not like", value, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeIn(List<String> values) {
            addCriterion("wi_expiration_time in", values, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeNotIn(List<String> values) {
            addCriterion("wi_expiration_time not in", values, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeBetween(String value1, String value2) {
            addCriterion("wi_expiration_time between", value1, value2, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiExpirationTimeNotBetween(String value1, String value2) {
            addCriterion("wi_expiration_time not between", value1, value2, "wiExpirationTime");
            return (Criteria) this;
        }

        public Criteria andWiServerIpIsNull() {
            addCriterion("wi_server_ip is null");
            return (Criteria) this;
        }

        public Criteria andWiServerIpIsNotNull() {
            addCriterion("wi_server_ip is not null");
            return (Criteria) this;
        }

        public Criteria andWiServerIpEqualTo(String value) {
            addCriterion("wi_server_ip =", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpNotEqualTo(String value) {
            addCriterion("wi_server_ip <>", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpGreaterThan(String value) {
            addCriterion("wi_server_ip >", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpGreaterThanOrEqualTo(String value) {
            addCriterion("wi_server_ip >=", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpLessThan(String value) {
            addCriterion("wi_server_ip <", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpLessThanOrEqualTo(String value) {
            addCriterion("wi_server_ip <=", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpLike(String value) {
            addCriterion("wi_server_ip like", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpNotLike(String value) {
            addCriterion("wi_server_ip not like", value, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpIn(List<String> values) {
            addCriterion("wi_server_ip in", values, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpNotIn(List<String> values) {
            addCriterion("wi_server_ip not in", values, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpBetween(String value1, String value2) {
            addCriterion("wi_server_ip between", value1, value2, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiServerIpNotBetween(String value1, String value2) {
            addCriterion("wi_server_ip not between", value1, value2, "wiServerIp");
            return (Criteria) this;
        }

        public Criteria andWiDnsIsNull() {
            addCriterion("wi_dns is null");
            return (Criteria) this;
        }

        public Criteria andWiDnsIsNotNull() {
            addCriterion("wi_dns is not null");
            return (Criteria) this;
        }

        public Criteria andWiDnsEqualTo(String value) {
            addCriterion("wi_dns =", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsNotEqualTo(String value) {
            addCriterion("wi_dns <>", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsGreaterThan(String value) {
            addCriterion("wi_dns >", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsGreaterThanOrEqualTo(String value) {
            addCriterion("wi_dns >=", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsLessThan(String value) {
            addCriterion("wi_dns <", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsLessThanOrEqualTo(String value) {
            addCriterion("wi_dns <=", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsLike(String value) {
            addCriterion("wi_dns like", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsNotLike(String value) {
            addCriterion("wi_dns not like", value, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsIn(List<String> values) {
            addCriterion("wi_dns in", values, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsNotIn(List<String> values) {
            addCriterion("wi_dns not in", values, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsBetween(String value1, String value2) {
            addCriterion("wi_dns between", value1, value2, "wiDns");
            return (Criteria) this;
        }

        public Criteria andWiDnsNotBetween(String value1, String value2) {
            addCriterion("wi_dns not between", value1, value2, "wiDns");
            return (Criteria) this;
        }

        public Criteria andLogicalDelIsNull() {
            addCriterion("logical_del is null");
            return (Criteria) this;
        }

        public Criteria andLogicalDelIsNotNull() {
            addCriterion("logical_del is not null");
            return (Criteria) this;
        }

        public Criteria andLogicalDelEqualTo(Boolean value) {
            addCriterion("logical_del =", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelNotEqualTo(Boolean value) {
            addCriterion("logical_del <>", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelGreaterThan(Boolean value) {
            addCriterion("logical_del >", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("logical_del >=", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelLessThan(Boolean value) {
            addCriterion("logical_del <", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelLessThanOrEqualTo(Boolean value) {
            addCriterion("logical_del <=", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelIn(List<Boolean> values) {
            addCriterion("logical_del in", values, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelNotIn(List<Boolean> values) {
            addCriterion("logical_del not in", values, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelBetween(Boolean value1, Boolean value2) {
            addCriterion("logical_del between", value1, value2, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("logical_del not between", value1, value2, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTransactionHashIsNull() {
            addCriterion("transaction_hash is null");
            return (Criteria) this;
        }

        public Criteria andTransactionHashIsNotNull() {
            addCriterion("transaction_hash is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionHashEqualTo(String value) {
            addCriterion("transaction_hash =", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotEqualTo(String value) {
            addCriterion("transaction_hash <>", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashGreaterThan(String value) {
            addCriterion("transaction_hash >", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_hash >=", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashLessThan(String value) {
            addCriterion("transaction_hash <", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashLessThanOrEqualTo(String value) {
            addCriterion("transaction_hash <=", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashLike(String value) {
            addCriterion("transaction_hash like", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotLike(String value) {
            addCriterion("transaction_hash not like", value, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashIn(List<String> values) {
            addCriterion("transaction_hash in", values, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotIn(List<String> values) {
            addCriterion("transaction_hash not in", values, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashBetween(String value1, String value2) {
            addCriterion("transaction_hash between", value1, value2, "transactionHash");
            return (Criteria) this;
        }

        public Criteria andTransactionHashNotBetween(String value1, String value2) {
            addCriterion("transaction_hash not between", value1, value2, "transactionHash");
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