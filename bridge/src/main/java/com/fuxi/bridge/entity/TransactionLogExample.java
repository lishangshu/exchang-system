package com.fuxi.bridge.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionLogExample() {
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBlockHashIsNull() {
            addCriterion("block_hash is null");
            return (Criteria) this;
        }

        public Criteria andBlockHashIsNotNull() {
            addCriterion("block_hash is not null");
            return (Criteria) this;
        }

        public Criteria andBlockHashEqualTo(String value) {
            addCriterion("block_hash =", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotEqualTo(String value) {
            addCriterion("block_hash <>", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashGreaterThan(String value) {
            addCriterion("block_hash >", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashGreaterThanOrEqualTo(String value) {
            addCriterion("block_hash >=", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashLessThan(String value) {
            addCriterion("block_hash <", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashLessThanOrEqualTo(String value) {
            addCriterion("block_hash <=", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashLike(String value) {
            addCriterion("block_hash like", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotLike(String value) {
            addCriterion("block_hash not like", value, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashIn(List<String> values) {
            addCriterion("block_hash in", values, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotIn(List<String> values) {
            addCriterion("block_hash not in", values, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashBetween(String value1, String value2) {
            addCriterion("block_hash between", value1, value2, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockHashNotBetween(String value1, String value2) {
            addCriterion("block_hash not between", value1, value2, "blockHash");
            return (Criteria) this;
        }

        public Criteria andBlockNumberIsNull() {
            addCriterion("block_number is null");
            return (Criteria) this;
        }

        public Criteria andBlockNumberIsNotNull() {
            addCriterion("block_number is not null");
            return (Criteria) this;
        }

        public Criteria andBlockNumberEqualTo(Integer value) {
            addCriterion("block_number =", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberNotEqualTo(Integer value) {
            addCriterion("block_number <>", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberGreaterThan(Integer value) {
            addCriterion("block_number >", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("block_number >=", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberLessThan(Integer value) {
            addCriterion("block_number <", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberLessThanOrEqualTo(Integer value) {
            addCriterion("block_number <=", value, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberIn(List<Integer> values) {
            addCriterion("block_number in", values, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberNotIn(List<Integer> values) {
            addCriterion("block_number not in", values, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberBetween(Integer value1, Integer value2) {
            addCriterion("block_number between", value1, value2, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andBlockNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("block_number not between", value1, value2, "blockNumber");
            return (Criteria) this;
        }

        public Criteria andLogIndexIsNull() {
            addCriterion("log_index is null");
            return (Criteria) this;
        }

        public Criteria andLogIndexIsNotNull() {
            addCriterion("log_index is not null");
            return (Criteria) this;
        }

        public Criteria andLogIndexEqualTo(Long value) {
            addCriterion("log_index =", value, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexNotEqualTo(Long value) {
            addCriterion("log_index <>", value, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexGreaterThan(Long value) {
            addCriterion("log_index >", value, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("log_index >=", value, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexLessThan(Long value) {
            addCriterion("log_index <", value, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexLessThanOrEqualTo(Long value) {
            addCriterion("log_index <=", value, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexIn(List<Long> values) {
            addCriterion("log_index in", values, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexNotIn(List<Long> values) {
            addCriterion("log_index not in", values, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexBetween(Long value1, Long value2) {
            addCriterion("log_index between", value1, value2, "logIndex");
            return (Criteria) this;
        }

        public Criteria andLogIndexNotBetween(Long value1, Long value2) {
            addCriterion("log_index not between", value1, value2, "logIndex");
            return (Criteria) this;
        }

        public Criteria andRemovedIsNull() {
            addCriterion("removed is null");
            return (Criteria) this;
        }

        public Criteria andRemovedIsNotNull() {
            addCriterion("removed is not null");
            return (Criteria) this;
        }

        public Criteria andRemovedEqualTo(Boolean value) {
            addCriterion("removed =", value, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedNotEqualTo(Boolean value) {
            addCriterion("removed <>", value, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedGreaterThan(Boolean value) {
            addCriterion("removed >", value, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("removed >=", value, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedLessThan(Boolean value) {
            addCriterion("removed <", value, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedLessThanOrEqualTo(Boolean value) {
            addCriterion("removed <=", value, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedIn(List<Boolean> values) {
            addCriterion("removed in", values, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedNotIn(List<Boolean> values) {
            addCriterion("removed not in", values, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedBetween(Boolean value1, Boolean value2) {
            addCriterion("removed between", value1, value2, "removed");
            return (Criteria) this;
        }

        public Criteria andRemovedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("removed not between", value1, value2, "removed");
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

        public Criteria andTransactionIndexIsNull() {
            addCriterion("transaction_index is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexIsNotNull() {
            addCriterion("transaction_index is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexEqualTo(Integer value) {
            addCriterion("transaction_index =", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexNotEqualTo(Integer value) {
            addCriterion("transaction_index <>", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexGreaterThan(Integer value) {
            addCriterion("transaction_index >", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("transaction_index >=", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexLessThan(Integer value) {
            addCriterion("transaction_index <", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexLessThanOrEqualTo(Integer value) {
            addCriterion("transaction_index <=", value, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexIn(List<Integer> values) {
            addCriterion("transaction_index in", values, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexNotIn(List<Integer> values) {
            addCriterion("transaction_index not in", values, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexBetween(Integer value1, Integer value2) {
            addCriterion("transaction_index between", value1, value2, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andTransactionIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("transaction_index not between", value1, value2, "transactionIndex");
            return (Criteria) this;
        }

        public Criteria andEventInAddressIsNull() {
            addCriterion("event_in_address is null");
            return (Criteria) this;
        }

        public Criteria andEventInAddressIsNotNull() {
            addCriterion("event_in_address is not null");
            return (Criteria) this;
        }

        public Criteria andEventInAddressEqualTo(String value) {
            addCriterion("event_in_address =", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressNotEqualTo(String value) {
            addCriterion("event_in_address <>", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressGreaterThan(String value) {
            addCriterion("event_in_address >", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressGreaterThanOrEqualTo(String value) {
            addCriterion("event_in_address >=", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressLessThan(String value) {
            addCriterion("event_in_address <", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressLessThanOrEqualTo(String value) {
            addCriterion("event_in_address <=", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressLike(String value) {
            addCriterion("event_in_address like", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressNotLike(String value) {
            addCriterion("event_in_address not like", value, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressIn(List<String> values) {
            addCriterion("event_in_address in", values, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressNotIn(List<String> values) {
            addCriterion("event_in_address not in", values, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressBetween(String value1, String value2) {
            addCriterion("event_in_address between", value1, value2, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventInAddressNotBetween(String value1, String value2) {
            addCriterion("event_in_address not between", value1, value2, "eventInAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressIsNull() {
            addCriterion("event_out_address is null");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressIsNotNull() {
            addCriterion("event_out_address is not null");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressEqualTo(String value) {
            addCriterion("event_out_address =", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressNotEqualTo(String value) {
            addCriterion("event_out_address <>", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressGreaterThan(String value) {
            addCriterion("event_out_address >", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressGreaterThanOrEqualTo(String value) {
            addCriterion("event_out_address >=", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressLessThan(String value) {
            addCriterion("event_out_address <", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressLessThanOrEqualTo(String value) {
            addCriterion("event_out_address <=", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressLike(String value) {
            addCriterion("event_out_address like", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressNotLike(String value) {
            addCriterion("event_out_address not like", value, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressIn(List<String> values) {
            addCriterion("event_out_address in", values, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressNotIn(List<String> values) {
            addCriterion("event_out_address not in", values, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressBetween(String value1, String value2) {
            addCriterion("event_out_address between", value1, value2, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventOutAddressNotBetween(String value1, String value2) {
            addCriterion("event_out_address not between", value1, value2, "eventOutAddress");
            return (Criteria) this;
        }

        public Criteria andEventAmountIsNull() {
            addCriterion("event_amount is null");
            return (Criteria) this;
        }

        public Criteria andEventAmountIsNotNull() {
            addCriterion("event_amount is not null");
            return (Criteria) this;
        }

        public Criteria andEventAmountEqualTo(BigDecimal value) {
            addCriterion("event_amount =", value, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountNotEqualTo(BigDecimal value) {
            addCriterion("event_amount <>", value, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountGreaterThan(BigDecimal value) {
            addCriterion("event_amount >", value, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("event_amount >=", value, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountLessThan(BigDecimal value) {
            addCriterion("event_amount <", value, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("event_amount <=", value, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountIn(List<BigDecimal> values) {
            addCriterion("event_amount in", values, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountNotIn(List<BigDecimal> values) {
            addCriterion("event_amount not in", values, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("event_amount between", value1, value2, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("event_amount not between", value1, value2, "eventAmount");
            return (Criteria) this;
        }

        public Criteria andEventMessageIsNull() {
            addCriterion("event_message is null");
            return (Criteria) this;
        }

        public Criteria andEventMessageIsNotNull() {
            addCriterion("event_message is not null");
            return (Criteria) this;
        }

        public Criteria andEventMessageEqualTo(String value) {
            addCriterion("event_message =", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageNotEqualTo(String value) {
            addCriterion("event_message <>", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageGreaterThan(String value) {
            addCriterion("event_message >", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageGreaterThanOrEqualTo(String value) {
            addCriterion("event_message >=", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageLessThan(String value) {
            addCriterion("event_message <", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageLessThanOrEqualTo(String value) {
            addCriterion("event_message <=", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageLike(String value) {
            addCriterion("event_message like", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageNotLike(String value) {
            addCriterion("event_message not like", value, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageIn(List<String> values) {
            addCriterion("event_message in", values, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageNotIn(List<String> values) {
            addCriterion("event_message not in", values, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageBetween(String value1, String value2) {
            addCriterion("event_message between", value1, value2, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventMessageNotBetween(String value1, String value2) {
            addCriterion("event_message not between", value1, value2, "eventMessage");
            return (Criteria) this;
        }

        public Criteria andEventTimestampIsNull() {
            addCriterion("event_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andEventTimestampIsNotNull() {
            addCriterion("event_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andEventTimestampEqualTo(Date value) {
            addCriterion("event_timestamp =", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampNotEqualTo(Date value) {
            addCriterion("event_timestamp <>", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampGreaterThan(Date value) {
            addCriterion("event_timestamp >", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("event_timestamp >=", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampLessThan(Date value) {
            addCriterion("event_timestamp <", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampLessThanOrEqualTo(Date value) {
            addCriterion("event_timestamp <=", value, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampIn(List<Date> values) {
            addCriterion("event_timestamp in", values, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampNotIn(List<Date> values) {
            addCriterion("event_timestamp not in", values, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampBetween(Date value1, Date value2) {
            addCriterion("event_timestamp between", value1, value2, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampNotBetween(Date value1, Date value2) {
            addCriterion("event_timestamp not between", value1, value2, "eventTimestamp");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvIsNull() {
            addCriterion("event_timestampV is null");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvIsNotNull() {
            addCriterion("event_timestampV is not null");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvEqualTo(Long value) {
            addCriterion("event_timestampV =", value, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvNotEqualTo(Long value) {
            addCriterion("event_timestampV <>", value, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvGreaterThan(Long value) {
            addCriterion("event_timestampV >", value, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvGreaterThanOrEqualTo(Long value) {
            addCriterion("event_timestampV >=", value, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvLessThan(Long value) {
            addCriterion("event_timestampV <", value, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvLessThanOrEqualTo(Long value) {
            addCriterion("event_timestampV <=", value, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvIn(List<Long> values) {
            addCriterion("event_timestampV in", values, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvNotIn(List<Long> values) {
            addCriterion("event_timestampV not in", values, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvBetween(Long value1, Long value2) {
            addCriterion("event_timestampV between", value1, value2, "eventTimestampv");
            return (Criteria) this;
        }

        public Criteria andEventTimestampvNotBetween(Long value1, Long value2) {
            addCriterion("event_timestampV not between", value1, value2, "eventTimestampv");
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