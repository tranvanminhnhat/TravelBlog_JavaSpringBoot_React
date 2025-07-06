import { GoogleLoginButton } from "../GoogleLoginButton";
import styles from "./LoginForm.module.scss";

const LoginForm = () => {
  return (
    <>
      <main className={styles.loginPage}>
        <section className={styles.loginForm}>
          <h1 className={styles.loginForm__Logo}>Sprow</h1>

          <form className={styles.loginForm__Body}>
            <input
              type="text"
              className={styles.loginForm__Input}
              placeholder="Số điện thoại, tên người dùng hoặc email"
            />
            <input
              type="password"
              className={styles.loginForm__Input}
              placeholder="Mật khẩu"
            />
            <button className={styles.loginForm__Submit} type="submit">
              Đăng nhập
            </button>
            <div className={styles.loginForm__Divider}>HOẶC</div>
            <GoogleLoginButton />
            <a href="#" className={styles.loginForm__Forgot}>
              Quên mật khẩu?
            </a>
          </form>

          <div className={styles.loginForm__Signup}>
            Bạn chưa có tài khoản ư? <a href="#">Đăng ký</a>
          </div>
        </section>
      </main>
    </>
  );
};

export default LoginForm;
