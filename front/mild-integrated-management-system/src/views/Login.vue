<template>
  <v-content>
    <v-container py-5>
      <v-layout align-center justify-center py-3>
        <v-flex xs12 sm8 md4>
          <v-card class="px-2 pb-3">
            <v-card-text>
              <v-layout justify-center pt-2>
                <v-avatar size="40px" color="pink">
                  <v-icon dark>
                    lock
                  </v-icon>
                  <!--                  <img src="https://vuetifyjs.com/apple-touch-icon-180x180.png" alt="avatar" />-->
                </v-avatar>
              </v-layout>
              <v-layout justify-center py-3>
                <div class="headline">
                  Sign in
                </div>
              </v-layout>

              <v-form>
                <v-text-field
                  v-model="email"
                  name="login"
                  label="Email Address"
                  type="text"
                  required
                  :rules="emailRules"
                />
                <v-text-field
                  id="password"
                  v-model="password"
                  name="Password"
                  label="Password"
                  type="password"
                  required
                  :rules="passwordRules"
                />
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-btn block color="info" @click="submit">
                Login
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </v-content>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      email: '',
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+/.test(v) || 'E-mail must be valid',
      ],
      password: '',
      passwordRules: [v => !!v || 'Password is required'],
    };
  },
  methods: {
    submit() {
      console.log(this.email, this.password);
    },
  },
};
</script>
