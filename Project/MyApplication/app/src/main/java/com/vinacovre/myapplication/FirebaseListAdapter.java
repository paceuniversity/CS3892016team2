package com.vinacovre.myapplication;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Faranda on 4/28/2016.
 */
//This right here is used to create the connection to the firebase when the ui is created, because our normal adapter is created when
    // ui is created and then the firebase information isnt pulled until later on so the project is just getting messed up
    // lets cross fingers and hope this works
public abstract class FirebaseListAdapter<T> extends BaseAdapter {
    private Query firebaseRef;
    private Class<T> mModelClass;
    private int mLayout;
    //The code I am referencing doesnt explain <T>, I assume its an abstract for Type but I cannot be certain
    //More research needed on this so I can fully understand my <code>
    private LayoutInflater mInflater;
    private List<T> mModels;
    private List<String> mKeys;
    private ChildEventListener mListener;

    //MModelClass allows Firebasse to marshall the data at a location into an instance of a class that you provide
    //The layout represents a single list item, Must populate an instance of the corresponding view with the data
    //from an instance of mModelClass
    //I may change the <T> to championship because the <T> may be pulled from the database


    public FirebaseListAdapter(Query mRef, Class<T> mModelClass, int mLayout, Activity activity){
        this.firebaseRef = mRef;
        this.mModelClass = mModelClass;
        this.mLayout = mLayout;
        mInflater = activity.getLayoutInflater();
        mModels = new ArrayList<T>();
        mKeys = new ArrayList<String>();

        //This looks for all child events and then we will map them to our interal arrayList, which backs ListView
        mListener = this.firebaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                T model = dataSnapshot.getValue(FirebaseListAdapter.this.mModelClass);
                String key = dataSnapshot.getKey();

                if(previousChildName == null)
                {
                    mModels.add(0,model);
                    mKeys.add(0,key);
                }else{
                    int previousIndex = mKeys.indexOf(previousChildName);
                    int nextIndex = previousIndex + 1;
                    if(nextIndex == mModels.size())
                    {
                        mModels.add(model);
                        mKeys.add(key);
                    }else{
                        mModels.add(nextIndex,model);
                        mKeys.add(nextIndex,key);
                    }
                }
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();
                T newModel = dataSnapshot.getValue(FirebaseListAdapter.this.mModelClass);
                int index = mKeys.indexOf(key);
                Log.e("keys", Integer.toString(index));
                Log.e("key", key);
                Log.v("index", Integer.toString(index));
                Log.v("keys", key);
                mModels.set(index, newModel);

                notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String key = dataSnapshot.getKey();
                int index = mKeys.indexOf(key);

                mKeys.remove(index);
                mModels.remove(index);

                notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                String key = dataSnapshot.getKey();
                T newModel = dataSnapshot.getValue(FirebaseListAdapter.this.mModelClass);
                int index = mKeys.indexOf(key);
                mModels.remove(index);
                mKeys.remove(index);

                if(previousChildName == null)
                {
                    mModels.add(0, newModel);
                    mKeys.add(0,key);
                }else{
                    int previousIndex = mKeys.indexOf(previousChildName);
                    int nextIndex = previousIndex + 1;
                    if(nextIndex == mModels.size())
                    {
                        mModels.add(newModel);
                        mKeys.add(key);

                    }else{
                        mModels.add(nextIndex, newModel);
                        mKeys.add(nextIndex, key);
                    }
                }
                notifyDataSetChanged();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("FirebaseListAdapter", "Listen was cancelled, no more updates will occur");
            }
        });
    }

    public void cleanup(){
        firebaseRef.removeEventListener(mListener);
        mModels.clear();
        mKeys.clear();
    }

    @Override
    public int getCount(){
        return mModels.size();
    }

    @Override
    public Object getItem(int i)
    {
        return mModels.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            view = mInflater.inflate(mLayout, viewGroup, false);
        }
        T model = mModels.get(i);

        populateView(view,model );
        return view;


    }

    protected abstract void populateView(View v, T model);


}
