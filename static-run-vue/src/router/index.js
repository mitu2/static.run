import { createRouter, createWebHistory } from "vue-router";


const routes = [
    {
        label: '首页',
        path: '/',
        name: 'Home',
        component: () => import('@/pages/HomePage.vue'),
    },
    {
        label: '留言板',
        path: '/leave-message',
        name: 'LeaveMessage',
        component: () => import('@/pages/LeaveMessage.vue')
    },
    {
        label: '小工具',
        path: '/',
        name: 'Tool',
        children: [
            {
                label: '正则编辑器',
                path: '/regexp',
                name: 'Regexp',
                component: () => import('@/pages/RegexpPage.vue') },
            {
                label: '短网址',
                path: '/short-url',
                name: 'ShortUrl',
                component: () => import('@/pages/ShortUrlPage.vue')
            },
        ]
    },
]


const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router;