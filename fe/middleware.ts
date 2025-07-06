import { getToken } from 'next-auth/jwt';
import { NextRequest, NextResponse } from 'next/server';

const protectedPaths = ['/post'];

export async function middleware(request: NextRequest) {
  // Get URL
  const path = request.nextUrl.pathname;

  // If url start with: /post
  // Then require login else can access page
  const isProtected = protectedPaths.some((prefix) => path.startsWith(prefix));
  if (!isProtected) return NextResponse.next();

  const token = await getToken({ req: request, secret: process.env.NEXTAUTH_SECRET });
  if (!token) {
    return NextResponse.redirect(new URL('/login', request.url));
  }

  return NextResponse.next();
}

export const config = {
  matcher: ['/post/:path*'],
};