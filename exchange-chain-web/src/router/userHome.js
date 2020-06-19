const addData = {
	path: '',
	name:'home',
	redirect: {
		name: 'information'
	},
	meta: {
		  title: '互联网数据交换平台-添加数据',
	},
	// component: () => import('@/views/layout/AddData'),
	component: () => import('@/components/RouterView'),
	children: [
		{
			path:'/list_detail',
			name:'list_detail',
			meta: {
				title: '互联网数据交换平台-首页table-详情'
		 	 },
			component: () => import('@/views/layout/ListDetaill'),
		},
		{
			path:'/information',
			name:'information',
			meta: {
				title: '互联网数据交换平台-账户信息详情'
		 	 },
			component: () => import('@/views/accountInformation/AccountInformation'),
		},
		{
			path: '/add_data',
			name:'add_data',
			meta: {
				title: '互联网数据交换平台-添加数据'
		 	 },
			  component: () => import('@/views/layout/AddData'),
		},
		{
			path: '/account_detail',
			redirect: {
				name: 'account_detail'
			},
			meta: {
				title: '账户',
			},
			component: () => import('@/components/RouterView'),
			children:[
				{
					path: '/account_detail',
					name:'account_detail',
					meta: {
						title: '互联网数据交换平台-账户详情'
					},
					component: () => import('@/views/accountInformation/AccountDetail'),
				},
				{
					path: '/account_details',
					name:'account_details',
					meta: {
						title: '互联网数据交换平台-账户详情-详情'
					},
					component: () => import('@/views/accountInformation/AccountDetailList'),
				},
			  ]
		},
		{
			path: '/release',
			name:'release',
			meta: {
				title: '发布记录',
			},
			component: () => import('@/components/RouterView'),
			children:[
				{
					path: '/release_record',
					name:'release_record',
					meta: {
						title: '互联网数据交换平台-发布记录'
					  },
					component: () => import('@/views/accountInformation/ReleaseRecord'),
				},
				{
					path: '/release_detail',
					name:'release_detail',
					meta: {
						title: '互联网数据交换平台-发布记录-详情'
					  },
					component: () => import('@/views/accountInformation/ReleaseDetail'),
				},
				{
					path: '/updata_release',
					name:'updata_release',
					meta: {
						title: '互联网数据交换平台-发布记录-修改'
					  },
					component: () => import('@/views/accountInformation/UpdataRelease'),
				}
			]
		},
		
	]
};

export default addData;