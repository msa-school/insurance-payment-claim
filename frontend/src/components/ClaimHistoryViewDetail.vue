<template>

    <v-card outlined>
        <v-card-title>
            ClaimHistory # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="ClaimId" v-model="item.claimId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ReviewerId" v-model="item.reviewerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DiseaseCode" v-model="item.diseaseCode" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Amount" v-model="item.amount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ReviewStatus" v-model="item.reviewStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PaymentStatus" v-model="item.paymentStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ClaimHistoryViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/claimHistories/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

