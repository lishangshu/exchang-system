// 登录/注册/未注册状态的首页
const indexHome = {
	path: '',
	meta: {
		  title: '互联网数据交换平台',
	},
	redirect: {
		name: 'exchange'
	  },
	component: () => import('@/components/RouterView'),
	children: [
		// {
		// 	path:'/home',
		// 	name:'noexchange',
		// 	meta: {
		// 		title: '互联网数据交换平台'
		//  	 },
		// 	component: () => import('@/views/user/Home'),
		// },
		{
			path:'/login',
			name:'login',
			meta: {
				title: '登录'
		 	 },
			component: () => import('@/views/user/Login'),
		},
		{
			path:'/register',
			name:'register',
			meta: {
				title: '注册'
		 	 },
			component: () => import('@/views/user/Register'),
		},
		{
			path:'/real_name',
			name:'real_name',
			meta: {
				title: '实名认证'
		 	 },
			component: () => import('@/views/user/RealName'),
		}

		
	]
};

export default indexHome;