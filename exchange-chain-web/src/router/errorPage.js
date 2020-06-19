const errorPage = {
  path: '',
  name: 'error-page',
  meta: {
    title: '互联网数据交换平台',
    name: '',
    code: ''
  },
  component: () => import('@/components/RouterView'),
  children:[
      {
        path: '403',
        name: 'page-403',
        meta: {
            title: '互联网数据交换平台',
            name: '',
            code: ''
        },
        component: () => import('@/components/errorPage/403'),
      },
      {
        path: '502',
        name: 'page-502',
        meta: {
            title: '互联网数据交换平台',
            name: '',
            code: ''
        },
        component: () => import('@/components/errorPage/502'),
      },
      {
        path: '404',
        name: 'page-404',
        meta: {
          title: '互联网数据交换平台',
          name: '',
          code: ''
        },
        component: () => import('@/components/errorPage/404'),
      },
  ]
};




export default errorPage;