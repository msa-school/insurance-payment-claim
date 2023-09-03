
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ClaimClaimManager from "./components/listers/ClaimClaimCards"
import ClaimClaimDetail from "./components/listers/ClaimClaimDetail"

import ReviewReviewManager from "./components/listers/ReviewReviewCards"
import ReviewReviewDetail from "./components/listers/ReviewReviewDetail"
import ReviewReviewerManager from "./components/listers/ReviewReviewerCards"
import ReviewReviewerDetail from "./components/listers/ReviewReviewerDetail"

import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"

import CustomerCustomerManager from "./components/listers/CustomerCustomerCards"
import CustomerCustomerDetail from "./components/listers/CustomerCustomerDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/claims/claims',
                name: 'ClaimClaimManager',
                component: ClaimClaimManager
            },
            {
                path: '/claims/claims/:id',
                name: 'ClaimClaimDetail',
                component: ClaimClaimDetail
            },

            {
                path: '/reviews/reviews',
                name: 'ReviewReviewManager',
                component: ReviewReviewManager
            },
            {
                path: '/reviews/reviews/:id',
                name: 'ReviewReviewDetail',
                component: ReviewReviewDetail
            },
            {
                path: '/reviews/reviewers',
                name: 'ReviewReviewerManager',
                component: ReviewReviewerManager
            },
            {
                path: '/reviews/reviewers/:id',
                name: 'ReviewReviewerDetail',
                component: ReviewReviewerDetail
            },

            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },

            {
                path: '/customers/customers',
                name: 'CustomerCustomerManager',
                component: CustomerCustomerManager
            },
            {
                path: '/customers/customers/:id',
                name: 'CustomerCustomerDetail',
                component: CustomerCustomerDetail
            },



    ]
})
