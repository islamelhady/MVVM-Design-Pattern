package com.elhady.mvvm_design_pattern;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import com.elhady.mvvm_design_pattern.databinding.ItemRepoBinding;
import com.elhady.mvvm_design_pattern.model.Repository;
import com.elhady.mvvm_design_pattern.viewmodel.ItemRepoViewModel;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private List<Repository> repositories;

    public RepositoryAdapter() {
        this.repositories = Collections.emptyList();
    }

    public RepositoryAdapter(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRepoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_repo,
                parent,
                false);
        return new RepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        holder.bindRepository(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public static class RepositoryViewHolder extends RecyclerView.ViewHolder {
        final ItemRepoBinding binding;

        public RepositoryViewHolder(ItemRepoBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }

        void bindRepository(Repository repository) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemRepoViewModel(itemView.getContext(), repository));
            } else {
                binding.getViewModel().setRepository(repository);
            }
        }
    }
}
