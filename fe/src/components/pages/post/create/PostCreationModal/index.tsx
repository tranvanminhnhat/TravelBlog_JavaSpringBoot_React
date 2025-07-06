import { useState } from "react";
import CaptionInput from "./CaptionInput";
import ImageUploader from "./ImageUploader";
import ReviewPost from "./ReviewPost";

const PostCreationModal = () => {
  const [step, setStep] = useState(1);
  return (
    <>
      <div>
        {step === 1 && <ImageUploader />}
        {step === 2 && <CaptionInput />}
        {step === 3 && <ReviewPost />}
      </div>
    </>
  );
};

export default PostCreationModal;
