<template>
  <v-app>
    <v-main app>
      <v-container class="pt-16 mt-16">
        <v-row justify="center" align="center">
          <v-col xs="12" sm="6" md="6" lg="6" xl="6">
            <v-card class="px-2">
              <v-card-title>
                <v-container>
                  <v-row justify="center">
                    <v-avatar size="60px" color="blue lighten-3">
                      <v-icon dark> Mild </v-icon>
                    </v-avatar>
                  </v-row>
                  <v-row justify="center" class="pt-3">
                    <div class="headline">
                      Sign in
                    </div>
                  </v-row>
                </v-container>
              </v-card-title>

              <v-card-text>
                <v-form>
                  <v-text-field
                    v-model="username"
                    name="username"
                    label="Username"
                    type="text"
                    :counter="20"
                    required
                    :error-messages="usernameErrors"
                    @input="$v.username.$touch()"
                    @blur="$v.username.$touch()"
                  />
                  <v-text-field
                    id="password"
                    v-model="password"
                    name="password"
                    label="Password"
                    :type="isShowPassword ? 'text' : 'password'"
                    :counter="20"
                    :append-icon="isShowPassword ? 'mdi-eye' : 'mdi-eye-off'"
                    required
                    :error-messages="passwordErrors"
                    @click:append="isShowPassword = !isShowPassword"
                    @change="$v.password.$touch()"
                    @blur="$v.password.$touch()"
                  />
                  <v-checkbox
                    v-model="isRemember"
                    label="Remember password."
                    required
                  ></v-checkbox>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-container>
                  <v-row justify="end">
                    <v-btn color="info" @click="clear()">
                      Clear
                    </v-btn>
                  </v-row>
                  <v-row class="mt-6">
                    <v-btn block color="primary" @click="submit"> Login </v-btn>
                  </v-row>
                  <v-row class="my-6">
                    <v-btn
                      block
                      color="secondary"
                      @click="$router.push('/Register')"
                    >
                      Register
                    </v-btn>
                  </v-row>
                </v-container>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import { validationMixin } from 'vuelidate';
import { required, minLength, maxLength } from 'vuelidate/lib/validators';

export default {
  name: 'Login',

  mixins: [validationMixin],
  validations: {
    username: { required, minLength: minLength(10), maxLength: maxLength(20) },
    password: { required, minLength: minLength(8), maxLength: maxLength(20) },
  },

  data() {
    return {
      username: '',
      password: '',
      isShowPassword: false,
      isRemember: false,
    };
  },

  computed: {
    usernameErrors() {
      const errors = [];
      if (!this.$v.username.$dirty) return errors;
      !this.$v.username.required && errors.push('Name is required.');
      !this.$v.username.minLength &&
        errors.push('Name must be at least 10 characters long');
      !this.$v.username.maxLength &&
        errors.push('Name must be at most 20 characters long');
      return errors;
    },
    passwordErrors() {
      const errors = [];
      if (!this.$v.password.$dirty) return errors;
      !this.$v.password.required && errors.push('Password is required.');
      !this.$v.password.minLength &&
        errors.push('Password must be at least 10 characters long');
      !this.$v.password.maxLength &&
        errors.push('Password must be at most 20 characters long');
      return errors;
    },
  },

  methods: {
    submit() {
      this.$v.$touch();
      console.log(this.username, this.password, this.isRemember);
    },
    clear() {
      this.$v.$reset();
      this.username = '';
      this.password = '';
      this.isRemember = false;
    },
  },
};
</script>
