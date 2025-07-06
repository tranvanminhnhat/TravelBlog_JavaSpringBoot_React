"use client"
import { API_ENDPOINTS } from '@/constants/api';
import { GoogleOAuthProvider, GoogleLogin } from '@react-oauth/google';
import api from '../../../../lib/axios';

export function GoogleLoginButton () {
  const handleSuccess = async (credentialResponse) => {
    const idToken = credentialResponse.credential;
    try {
      const response = await api.post(API_ENDPOINTS.GOOGLE_LOGIN, { idToken });
      const jwt = response.data.jwt;
      localStorage.setItem('jwt', jwt);
      alert('success');
    } catch (err) {
      console.error(err);
      alert('error');
    }
  };

  return (
    <GoogleOAuthProvider clientId={process.env.NEXT_PUBLIC_GOOGLE_CLIENT_ID}>
      <GoogleLogin
        onSuccess={handleSuccess}
        onError={() => alert('Đăng nhập thất bại')}
      />
    </GoogleOAuthProvider>
  );
};