export default {
    data() {
        return {
            SpinStatus: true,
        }
    },
    methods: {
        showSpin() {
            this.SpinStatus = true;
        },
        hideSpin() {
            this.SpinStatus = false;
        }
    }

}