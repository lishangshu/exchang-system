import IndexHome from "@/router/indexHome"
import ExchangeHome from "@/router/exchangeHome"
import Layout from "@/router/layout"
import userHome from "@/router/userHome"
import ErrorPage from "@/router/errorPage"

export const routers = [
    {
        path: '/',
        redirect: {
            name: 'exchange'
        },
        component: () => import('@/components/RouterView'),
        children:[
            IndexHome,
            ExchangeHome,
            Layout,
            userHome,
            ErrorPage
        ]
    },
    {
        path: '*',
        redirect: {
            name: 'page-404'
        }
    },
]

