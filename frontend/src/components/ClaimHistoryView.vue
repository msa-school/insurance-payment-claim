<template>

    <v-data-table
        :headers="headers"
        :items="claimHistory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ClaimHistoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "claimId", value: "claimId" },
                { text: "reviewerId", value: "reviewerId" },
                { text: "customerId", value: "customerId" },
                { text: "diseaseCode", value: "diseaseCode" },
                { text: "amount", value: "amount" },
                { text: "reviewStatus", value: "reviewStatus" },
                { text: "paymentStatus", value: "paymentStatus" },
                { text: "status", value: "status" },
            ],
            claimHistory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/claimHistories'))

            temp.data._embedded.claimHistories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.claimHistory = temp.data._embedded.claimHistories;
        },
        methods: {
        }
    }
</script>

