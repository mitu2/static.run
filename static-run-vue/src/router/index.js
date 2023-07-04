import { createRouter, createWebHistory } from "vue-router";


const routes = [
    { path: '/', name: 'Home', component: () => import('@/pages/HomePage.vue') },
    { path: '/leave-message', name: 'LeaveMessage', component: () => import('@/pages/LeaveMessage.vue') },
    { path: '/regexp', name: 'Regexp', component: () => import('@/pages/RegexpPage.vue') },
    { path: '/short-url', name: 'ShortUrl', component: () => import('@/pages/ShortUrlPage.vue') },
]


const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router;